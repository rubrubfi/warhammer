PGDMP     
    #            
    x         	   warhammer    12.2    12.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16540 	   warhammer    DATABASE     �   CREATE DATABASE warhammer WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE warhammer;
                postgres    false            �            1259    16541    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    nombre character varying(20) NOT NULL,
    correo character varying NOT NULL,
    "contraseña" character varying NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �
          0    16541    usuario 
   TABLE DATA           D   COPY public.usuario (id, nombre, correo, "contraseña") FROM stdin;
    public          postgres    false    202   �       
           2606    16548    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    202            �
      x������ � �     