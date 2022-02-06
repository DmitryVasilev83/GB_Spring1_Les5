package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.dao.NamedParameterJDBCTemplateManufacturerDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
//4
//@Component
@RequiredArgsConstructor
public class NamedParameterJDBCTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, (rs, rn) ->
                Product.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .date(rs.getDate("manufacture_date").toLocalDate())
                        .id(rs.getLong("manufacture_id"))
                        .build());
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM product where id = " + id;
        Iterable<Product> itProd= namedParameterJdbcTemplate.query(sql, (rs, rn) ->
                Product.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .date(rs.getDate("manufacture_date").toLocalDate())
                        .id(rs.getLong("manufacture_id"))
                        .build());
        return itProd.iterator().next();
    }

    @Override
    public String findTitleById(Long id) {
        String sql = "SELECT title FROM product where id = :productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

}
