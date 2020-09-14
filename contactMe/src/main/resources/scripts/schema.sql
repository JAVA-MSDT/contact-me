DROP TABLE IF EXISTS address CASCADE; 
DROP TABLE IF EXISTS email CASCADE; 
DROP TABLE IF EXISTS image CASCADE; 
DROP TABLE IF EXISTS job CASCADE; 
DROP TABLE IF EXISTS phone_number CASCADE; 
DROP TABLE IF EXISTS social_network CASCADE; 
DROP TABLE IF EXISTS users CASCADE; 

CREATE TABLE address 
   (
      id BIGSERIAL, 
      bulding_number VARCHAR(255), 
      city VARCHAR(255), 
      country VARCHAR(255), 
      flat_number VARCHAR(255), 
      main_address boolean, 
      province VARCHAR(255), 
      street_name VARCHAR(255), 
      version BIGINT NOT NULL, 
      zipcode VARCHAR(255), 
      user_id BIGINT, 
      PRIMARY KEY (id)
    );
    
CREATE TABLE email 
    ( 
      id BIGSERIAL, 
      email VARCHAR(255), 
      version BIGINT NOT NULL, 
      job_id BIGINT, 
      user_id BIGINT, 
      PRIMARY KEY (id)
    );
    
CREATE TABLE image 
    (
      id BIGSERIAL, 
      image binary(255), 
      image_title VARCHAR(255), 
      main_image boolean, 
      version BIGINT NOT NULL, 
      user_id BIGINT, 
      PRIMARY KEY (id)
    );
    
CREATE TABLE job 
    (
      id BIGSERIAL, 
      company_name VARCHAR(255), 
      job_position VARCHAR(255), 
      job_title VARCHAR(255), 
      version BIGINT NOT NULL, 
      address_id BIGINT, 
      image_id BIGINT, 
      user_id BIGINT, 
      PRIMARY KEY (id)
    );
    
CREATE TABLE phone_number 
    (
      id BIGSERIAL, 
      country_code VARCHAR(255), 
      main_number boolean, 
      phone_number VARCHAR(255), 
      version BIGINT NOT NULL, 
      job_id BIGINT, 
      user_id BIGINT, 
      PRIMARY KEY (id)
    );
    
CREATE TABLE social_network 
    (
      id BIGSERIAL, 
      link VARCHAR(255), 
      social_title VARCHAR(255), 
      version BIGINT NOT NULL, 
      user_id BIGINT, 
      PRIMARY KEY (id)
    );
    
CREATE TABLE users 
    (
      id BIGSERIAL, 
      enabled BOOLEAN DEFAULT true, 
      first_name VARCHAR(255), 
      last_name VARCHAR(255), 
      middle_name VARCHAR(255), 
      password VARCHAR(255) NOT NULL, 
      role VARCHAR(255), 
      username VARCHAR(255) NOT NULL, 
      version BIGINT NOT NULL, 
      contact_id BIGINT, 
      PRIMARY KEY (id)
    );
    
alter table address add constraint FK6i66ijb8twgcqtetl8eeeed6v foreign key (user_id) references users;
alter table email add constraint FKo1qipcbpe08ymxs7707kj8phv foreign key (job_id) references job;
alter table email add constraint FKah6v1juek8jb9ycg8cldv15d6 foreign key (user_id) references users;
alter table image add constraint FKcvpnctgluno47ac6avana5sqf foreign key (user_id) references users;
alter table job add constraint FKm7qamwx91t03sgq0p93gm8kri foreign key (address_id) references address;
alter table job add constraint FKmuikgabg5ch8brciwyvtbmlm5 foreign key (image_id) references image;
alter table job add constraint FKpjwg3kcmu25r91o9x9nm6ha56 foreign key (user_id) references users;
alter table phone_number add constraint FKjy7sipyfipf869qo4h2i6djng foreign key (job_id) references job;
alter table phone_number add constraint FKa2rs298303a3x456x2mpqje9s foreign key (user_id) references users;
alter table social_network add constraint FKohcgxr6lm9m3q9srl14lc7h19 foreign key (user_id) references users;
alter table users add constraint FKkvhhi2m6eotfbu7bl5mqxmlaa foreign key (contact_id) references users;

