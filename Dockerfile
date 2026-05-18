FROM postgres
ENV POSTGRES_DB="Bakery"
COPY initial_data.sql /docker-entrypoint-initdb.d/