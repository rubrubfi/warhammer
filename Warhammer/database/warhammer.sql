PGDMP          )            
    x         	   warhammer    12.2    12.2     
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16540 	   warhammer    DATABASE     �   CREATE DATABASE warhammer WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE warhammer;
                postgres    false            �            1259    16549 	   personaje    TABLE       CREATE TABLE public.personaje (
    id_personaje integer NOT NULL,
    nombre character varying NOT NULL,
    raza character varying NOT NULL,
    clase character varying NOT NULL,
    edad integer NOT NULL,
    genero character varying NOT NULL,
    idusuario integer NOT NULL
);
    DROP TABLE public.personaje;
       public         heap    postgres    false            �            1259    16541    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    nombre character varying(20) NOT NULL,
    correo character varying NOT NULL,
    "contraseña" character varying NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false                      0    16549 	   personaje 
   TABLE DATA           _   COPY public.personaje (id_personaje, nombre, raza, clase, edad, genero, idusuario) FROM stdin;
    public          postgres    false    203                    0    16541    usuario 
   TABLE DATA           D   COPY public.usuario (id, nombre, correo, "contraseña") FROM stdin;
    public          postgres    false    202   g       �
           2606    16556    personaje personaje_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.personaje
    ADD CONSTRAINT personaje_pkey PRIMARY KEY (id_personaje);
 B   ALTER TABLE ONLY public.personaje DROP CONSTRAINT personaje_pkey;
       public            postgres    false    203            �
           2606    16548    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    202            �
           2606    16569    personaje idusuario    FK CONSTRAINT     �   ALTER TABLE ONLY public.personaje
    ADD CONSTRAINT idusuario FOREIGN KEY (idusuario) REFERENCES public.usuario(id) DEFERRABLE NOT VALID;
 =   ALTER TABLE ONLY public.personaje DROP CONSTRAINT idusuario;
       public          postgres    false    202    203    2692               T   x�3�t�����t�K���O��M,I,)���)�440 r��Ks2��9�9KR�K8=Js!Js���KS�j��q��qqq 0�         u   x�-�1�0 ��1(q���K;����)��n:]+��s��#2��[�1���=4E4| `9�u�49���ja�-��d%���<�������m/����kJF<	%F�I,m1�� >��)�     