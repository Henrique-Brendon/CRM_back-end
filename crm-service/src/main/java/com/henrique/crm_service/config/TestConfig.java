package com.henrique.crm_service.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.henrique.crm_service.entities.CepInfo;
import com.henrique.crm_service.entities.Cliente;
import com.henrique.crm_service.entities.Proposta;
import com.henrique.crm_service.entities.Vendedor;
import com.henrique.crm_service.entities.enums.EstadoProposta;
import com.henrique.crm_service.repositories.ClienteRepository;
import com.henrique.crm_service.repositories.PropostaRepository;
import com.henrique.crm_service.repositories.VendedorRepository;

@Configuration
@Component
public class TestConfig implements CommandLineRunner {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PropostaRepository propostaRepository;

    @Override
    public void run(String... args) throws Exception {
        // 1. Salvar vendedores
        List<Vendedor> listaDeVendedores = Arrays.asList(
            new Vendedor(null, "Anna"),
            new Vendedor(null, "Augusto"),
            new Vendedor(null, "Bruna"),
            new Vendedor(null, "Diego")
        );
        vendedorRepository.saveAll(listaDeVendedores);

        // 2. Criar e salvar clientes (sem proposta ainda)
        List<Cliente> listaDeClientes = Arrays.asList(
            new Cliente(null, "João Silva", Instant.parse("1990-01-01T00:00:00Z"), "joao@email.com", "1234567", "123.456.789-00",
                    listaDeVendedores.get(0), new CepInfo("01001-000", "SP", "São Paulo", "Centro", "Rua A", "100"), null),
            new Cliente(null, "Maria Souza", Instant.parse("1985-05-10T00:00:00Z"), "maria@email.com", "2345678", "234.567.890-11",
                    listaDeVendedores.get(1), new CepInfo("20000-000", "RJ", "Rio de Janeiro", "Copacabana", "Rua B", "200"), null),
            new Cliente(null, "Carlos Lima", Instant.parse("1992-03-15T00:00:00Z"), "carlos@email.com", "3456789", "345.678.901-22",
                    listaDeVendedores.get(2), new CepInfo("30110-000", "MG", "Belo Horizonte", "Savassi", "Rua C", "300"), null),
            new Cliente(null, "Ana Paula", Instant.parse("1998-07-20T00:00:00Z"), "ana@email.com", "4567890", "456.789.012-33",
                    listaDeVendedores.get(3), new CepInfo("40000-000", "BA", "Salvador", "Barra", "Rua D", "400"), null),
            new Cliente(null, "Pedro Martins", Instant.parse("1995-09-25T00:00:00Z"), "pedro@email.com", "5678901", "567.890.123-44",
                    listaDeVendedores.get(0), new CepInfo("50000-000", "PE", "Recife", "Boa Viagem", "Rua E", "500"), null),
            new Cliente(null, "Juliana Rocha", Instant.parse("1991-11-30T00:00:00Z"), "juliana@email.com", "6789012", "678.901.234-55",
                    listaDeVendedores.get(1), new CepInfo("60000-000", "CE", "Fortaleza", "Meireles", "Rua F", "600"), null),
            new Cliente(null, "Bruno Alves", Instant.parse("1989-04-18T00:00:00Z"), "bruno@email.com", "7890123", "789.012.345-66",
                    listaDeVendedores.get(2), new CepInfo("70000-000", "DF", "Brasília", "Asa Sul", "Rua G", "700"), null),
            new Cliente(null, "Renata Dias", Instant.parse("1996-02-27T00:00:00Z"), "renata@email.com", "8901234", "890.123.456-77",
                    listaDeVendedores.get(3), new CepInfo("80000-000", "PR", "Curitiba", "Centro", "Rua H", "800"), null),
            new Cliente(null, "Thiago Gomes", Instant.parse("1993-06-05T00:00:00Z"), "thiago@email.com", "9012345", "901.234.567-88",
                    listaDeVendedores.get(0), new CepInfo("90000-000", "RS", "Porto Alegre", "Moinhos", "Rua I", "900"), null),
            new Cliente(null, "Larissa Melo", Instant.parse("2000-12-12T00:00:00Z"), "larissa@email.com", "0123456", "012.345.678-99",
                    listaDeVendedores.get(1), new CepInfo("99000-000", "RS", "Passo Fundo", "Centro", "Rua J", "1000"), null),
            new Cliente(null, "Eduardo Farias", Instant.parse("1987-08-01T00:00:00Z"), "eduardo@email.com", "1111111", "111.111.111-11",
                listaDeVendedores.get(0), new CepInfo("01111-000", "SP", "Campinas", "Centro", "Rua K", "1100"), null),
            new Cliente(null, "Sandra Lopes", Instant.parse("1982-10-12T00:00:00Z"), "sandra@email.com", "2222222", "222.222.222-22",
                listaDeVendedores.get(1), new CepInfo("02222-000", "RJ", "Niterói", "Icaraí", "Rua L", "1200"), null),
            new Cliente(null, "Fernando Dias", Instant.parse("1990-03-22T00:00:00Z"), "fernando@email.com", "3333333", "333.333.333-33",
                listaDeVendedores.get(2), new CepInfo("03333-000", "MG", "Uberlândia", "Centro", "Rua M", "1300"), null),
            new Cliente(null, "Letícia Moura", Instant.parse("1994-06-30T00:00:00Z"), "leticia@email.com", "4444444", "444.444.444-44",
                listaDeVendedores.get(3), new CepInfo("04444-000", "BA", "Feira de Santana", "Centro", "Rua N", "1400"), null),
            new Cliente(null, "Rafael Campos", Instant.parse("1988-01-05T00:00:00Z"), "rafael@email.com", "5555555", "555.555.555-55",
                listaDeVendedores.get(0), new CepInfo("05555-000", "SC", "Florianópolis", "Trindade", "Rua O", "1500"), null),
            new Cliente(null, "Marina Duarte", Instant.parse("1996-09-14T00:00:00Z"), "marina@email.com", "6666666", "666.666.666-66",
                listaDeVendedores.get(1), new CepInfo("06666-000", "PR", "Maringá", "Zona 1", "Rua P", "1600"), null),
           new Cliente(null, "Igor Nascimento", Instant.parse("1992-11-19T00:00:00Z"), "igor@email.com", "7777777", "777.777.777-77",
                listaDeVendedores.get(2), new CepInfo("07777-000", "PA", "Belém", "Nazaré", "Rua Q", "1700"), null),
           new Cliente(null, "Carla Teixeira", Instant.parse("1985-04-25T00:00:00Z"), "carla@email.com", "8888888", "888.888.888-88",
                listaDeVendedores.get(3), new CepInfo("08888-000", "MA", "São Luís", "Cohama", "Rua R", "1800"), null),
           new Cliente(null, "Roberto Menezes", Instant.parse("1997-07-07T00:00:00Z"), "roberto@email.com", "9999999", "999.999.999-99",
                listaDeVendedores.get(0), new CepInfo("09999-000", "GO", "Goiânia", "Setor Bueno", "Rua S", "1900"), null),
           new Cliente(null, "Patrícia Alves", Instant.parse("1999-12-31T00:00:00Z"), "patricia@email.com", "1010101", "101.010.101-01",
                listaDeVendedores.get(1), new CepInfo("10101-000", "TO", "Palmas", "Centro", "Rua T", "2000"), null),
           new Cliente(null, "Vinícius Prado", Instant.parse("1993-10-10T00:00:00Z"), "vinicius@email.com", "1212121", "121.212.121-21",
                listaDeVendedores.get(2), new CepInfo("12121-000", "AM", "Manaus", "Centro", "Rua U", "2100"), null),
           new Cliente(null, "Elaine Costa", Instant.parse("1980-05-02T00:00:00Z"), "elaine@email.com", "1313131", "131.313.131-31",
                listaDeVendedores.get(3), new CepInfo("13131-000", "AC", "Rio Branco", "Bosque", "Rua V", "2200"), null),
           new Cliente(null, "Maurício Pinto", Instant.parse("1991-03-11T00:00:00Z"), "mauricio@email.com", "1414141", "141.414.141-41",
                listaDeVendedores.get(0), new CepInfo("14141-000", "SE", "Aracaju", "Atalaia", "Rua W", "2300"), null),
           new Cliente(null, "Daniele Lima", Instant.parse("1995-06-18T00:00:00Z"), "daniele@email.com", "1515151", "151.515.151-51",
                listaDeVendedores.get(1), new CepInfo("15151-000", "PI", "Teresina", "Centro", "Rua X", "2400"), null),
          new Cliente(null, "Marcelo Gonçalves", Instant.parse("1983-08-09T00:00:00Z"), "marcelo@email.com", "1616161", "161.616.161-61",
                listaDeVendedores.get(2), new CepInfo("16161-000", "RO", "Porto Velho", "Centro", "Rua Y", "2500"), null),
          new Cliente(null, "Camila Batista", Instant.parse("1998-02-14T00:00:00Z"), "camila@email.com", "1717171", "171.717.171-71",
                listaDeVendedores.get(3), new CepInfo("17171-000", "RR", "Boa Vista", "Centro", "Rua Z", "2600"), null),
          new Cliente(null, "André Souza", Instant.parse("1990-09-09T00:00:00Z"), "andre@email.com", "1818181", "181.818.181-81",
                listaDeVendedores.get(0), new CepInfo("18181-000", "AP", "Macapá", "Centro", "Rua AA", "2700"), null),
          new Cliente(null, "Beatriz Moura", Instant.parse("1986-11-27T00:00:00Z"), "beatriz@email.com", "1919191", "191.919.191-91",
                listaDeVendedores.get(1), new CepInfo("19191-000", "AL", "Maceió", "Pajuçara", "Rua BB", "2800"), null),
          new Cliente(null, "Lucas Ribeiro", Instant.parse("1994-07-23T00:00:00Z"), "lucas@email.com", "2020202", "202.020.202-02",
                listaDeVendedores.get(2), new CepInfo("20202-000", "MT", "Cuiabá", "Centro", "Rua CC", "2900"), null),
          new Cliente(null, "Aline Ferreira", Instant.parse("1992-05-15T00:00:00Z"), "aline@email.com", "2121212", "212.121.212-12",
                listaDeVendedores.get(3), new CepInfo("21212-000", "MS", "Campo Grande", "Centro", "Rua DD", "3000"), null),

          new Cliente(null, "Jonathan Silva", Instant.parse("1996-01-30T00:00:00Z"), "jonathan@email.com", "2222223", "222.333.444-55",
                listaDeVendedores.get(0), new CepInfo("22223-000", "SP", "Sorocaba", "Jd. América", "Rua EE", "3100"), null),
          new Cliente(null, "Nathalia Rocha", Instant.parse("1997-03-17T00:00:00Z"), "nathalia@email.com", "2323232", "233.344.455-66",
                listaDeVendedores.get(1), new CepInfo("23232-000", "PR", "Londrina", "Centro", "Rua FF", "3200"), null),
          new Cliente(null, "João Silva", Instant.parse("1990-01-01T00:00:00Z"), "joao@email.com", "1234567", "123.456.789-00",
                    listaDeVendedores.get(0), new CepInfo("01001-000", "SP", "São Paulo", "Centro", "Rua A", "100"), null),
          new Cliente(null, "Maria Souza", Instant.parse("1985-05-10T00:00:00Z"), "maria@email.com", "2345678", "234.567.890-11",
                listaDeVendedores.get(1), new CepInfo("20000-000", "RJ", "Rio de Janeiro", "Copacabana", "Rua B", "200"), null),
          new Cliente(null, "Carlos Lima", Instant.parse("1992-03-15T00:00:00Z"), "carlos@email.com", "3456789", "345.678.901-22",
                listaDeVendedores.get(2), new CepInfo("30110-000", "MG", "Belo Horizonte", "Savassi", "Rua C", "300"), null),
          new Cliente(null, "Ana Paula", Instant.parse("1998-07-20T00:00:00Z"), "ana@email.com", "4567890", "456.789.012-33",
                listaDeVendedores.get(3), new CepInfo("40000-000", "BA", "Salvador", "Barra", "Rua D", "400"), null),
          new Cliente(null, "Pedro Martins", Instant.parse("1995-09-25T00:00:00Z"), "pedro@email.com", "5678901", "567.890.123-44",
                listaDeVendedores.get(0), new CepInfo("50000-000", "PE", "Recife", "Boa Viagem", "Rua E", "500"), null),
          new Cliente(null, "Juliana Rocha", Instant.parse("1991-11-30T00:00:00Z"), "juliana@email.com", "6789012", "678.901.234-55",
                listaDeVendedores.get(1), new CepInfo("60000-000", "CE", "Fortaleza", "Meireles", "Rua F", "600"), null),
          new Cliente(null, "Bruno Alves", Instant.parse("1989-04-18T00:00:00Z"), "bruno@email.com", "7890123", "789.012.345-66",
                listaDeVendedores.get(2), new CepInfo("70000-000", "DF", "Brasília", "Asa Sul", "Rua G", "700"), null),
          new Cliente(null, "Renata Dias", Instant.parse("1996-02-27T00:00:00Z"), "renata@email.com", "8901234", "890.123.456-77",
                listaDeVendedores.get(3), new CepInfo("80000-000", "PR", "Curitiba", "Centro", "Rua H", "800"), null)
          
        );
        clienteRepository.saveAll(listaDeClientes);

        // 3. Criar e salvar propostas vinculadas aos clientes
        Random random = new Random();

        List<Proposta> propostas = Arrays.asList(
                new Proposta(null, Instant.now(), new BigDecimal("1500.00"), "3 X 500", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(0)),
                new Proposta(null, Instant.now(), new BigDecimal("2500.00"), "5 X 500", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(1)),
                new Proposta(null, Instant.now(), new BigDecimal("1800.00"), "4 X 575", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(2)),
                new Proposta(null, Instant.now(), new BigDecimal("3000.00"), "6 X 500", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(3)),
                new Proposta(null, Instant.now(), new BigDecimal("2200.00"), "3 X 733,33", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(4)),
                new Proposta(null, Instant.now(), new BigDecimal("1900.00"), "2 X 950", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(5)),
                new Proposta(null, Instant.now(), new BigDecimal("3100.00"), "5 X", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(6)),
                new Proposta(null, Instant.now(), new BigDecimal("2700.00"), "4 X 675", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(7)),
                new Proposta(null, Instant.now(), new BigDecimal("2300.00"), "3 X 766,66", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(8)),
                new Proposta(null, Instant.now(), new BigDecimal("2000.00"), "2 X 1000", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(9)),
                new Proposta(null, Instant.now(), new BigDecimal("1400.00"), "4 X 350", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(10)),
                new Proposta(null, Instant.now(), new BigDecimal("3600.00"), "6 X 600", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(11)),
                new Proposta(null, Instant.now(), new BigDecimal("2100.00"), "3 X 700", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(12)),
                new Proposta(null, Instant.now(), new BigDecimal("1800.00"), "6 X 300", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(13)),
                new Proposta(null, Instant.now(), new BigDecimal("2250.00"), "5 X 450", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(14)),
                new Proposta(null, Instant.now(), new BigDecimal("2400.00"), "4 X 600", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(15)),
                new Proposta(null, Instant.now(), new BigDecimal("3200.00"), "8 X 400", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(16)),
                new Proposta(null, Instant.now(), new BigDecimal("1100.00"), "2 X 550", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(17)),
                new Proposta(null, Instant.now(), new BigDecimal("2700.00"), "3 X 900", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(18)),
                new Proposta(null, Instant.now(), new BigDecimal("3300.00"), "6 X 550", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(19)),
                new Proposta(null, Instant.now(), new BigDecimal("1600.00"), "4 X 400", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(20)),
                new Proposta(null, Instant.now(), new BigDecimal("2900.00"), "5 X 580", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(21)),
                new Proposta(null, Instant.now(), new BigDecimal("3500.00"), "7 X 500", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(22)),
                new Proposta(null, Instant.now(), new BigDecimal("1900.00"), "2 X 950", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(23)),
                new Proposta(null, Instant.now(), new BigDecimal("2800.00"), "4 X 700", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(24)),
                new Proposta(null, Instant.now(), new BigDecimal("1200.00"), "2 X 600", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(25)),
                new Proposta(null, Instant.now(), new BigDecimal("1600.00"), "4 X 400", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(26)),
                new Proposta(null, Instant.now(), new BigDecimal("2000.00"), "5 X 400", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(27)),
                new Proposta(null, Instant.now(), new BigDecimal("2600.00"), "4 X 650", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(28)),
                new Proposta(null, Instant.now(), new BigDecimal("3100.00"), "5 X 620", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(29)),
                new Proposta(null, Instant.now(), new BigDecimal("1700.00"), "2 X 850", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(30)),
                new Proposta(null, Instant.now(), new BigDecimal("2200.00"), "4 X 550", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(31)),
                new Proposta(null, Instant.now(), new BigDecimal("1800.00"), "3 X 600", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(32)),
                new Proposta(null, Instant.now(), new BigDecimal("3000.00"), "6 X 500", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(33)),
                new Proposta(null, Instant.now(), new BigDecimal("1900.00"), "2 X 950", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(34)),
                new Proposta(null, Instant.now(), new BigDecimal("3400.00"), "4 X 850", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(35)),
                new Proposta(null, Instant.now(), new BigDecimal("2000.00"), "2 X 1000", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(36)),
                new Proposta(null, Instant.now(), new BigDecimal("2750.00"), "5 X 550", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(37)),
                new Proposta(null, Instant.now(), new BigDecimal("3600.00"), "6 X 600", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(38)),
                new Proposta(null, Instant.now(), new BigDecimal("1500.00"), "3 X 500", EstadoProposta.values()[random.nextInt(EstadoProposta.values().length)], listaDeClientes.get(39))
        );

        propostaRepository.saveAll(propostas);




        // 4. Atualizar os clientes com as propostas salvas
        for (int i = 0; i < listaDeClientes.size(); i++) {
            listaDeClientes.get(i).setProposta(propostas.get(i));
        }

        clienteRepository.saveAll(listaDeClientes); // Atualiza com as propostas vinculadas
    }
}
