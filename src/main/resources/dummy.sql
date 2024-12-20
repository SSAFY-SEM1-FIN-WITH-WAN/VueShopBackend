USE whats_you_db;

-- 관리자 계정
INSERT INTO User (type, account_id, password, nickname, birth_date, zodiac_sign, file_name, file_path, created_at) VALUES 
('super', 'admin', 'admin', 'admin', '2000-01-01', '염소자리', 'images/profiles/980970d3-3772-4a59-9f1c-a02680e19720.png', 'https://firebasestorage.googleapis.com/v0/b/whatsyoulook-11c33.firebasestorage.app/o/images%2Fprofiles%2F980970d3-3772-4a59-9f1c-a02680e19720.png?alt=media&token=5a619049-f799-432e-aac2-bbeced00195f', '2000-01-01 00:00:00');

INSERT INTO clothimage (original_name, unique_name, min_tmp, max_tmp)
        VALUES 
        ('겨울3', '456313d1-47d2-4dde-9b78-c2eeec7ae6e0_1732499059544_겨울3.jpg', '-20', '40'),
        ('여착장', '76657504-b5ad-4285-8e24-94d453e61b37_1732515502969_여착장.png', '-20', '40'),
        ('겨울3', '456313d1-47d2-4dde-9b78-c2eeec7ae6e0_1732499059544_겨울3.jpg', '-20', '40');

-- 일반 계정
INSERT INTO User (account_id, password, nickname, birth_date, zodiac_sign, file_name, file_path, created_at) VALUES
('test1', 'test1', '펭하', '1999-10-31', '전갈자리', 'images/profiles/d69017b0-4403-4fad-80ca-40e1395b6b67.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/d69017b0-4403-4fad-80ca-40e1395b6b67.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733323647&Signature=fY6wNL00LEG5SQABYQ6yjUXY%2FjUSYyLkuZpYQbndn4vvGQtUnIGVKiklS5X6GTyC83ESYtCYmvW4OwDK4ojBW663P2ce7TIrFk0Dn2xpo%2FlugoAbQOj8YrcGLgKNFN%2FFi91iB152CwcfFIgrVL6KdkSiDJXZsjZ4U8dJmY3%2B744JnQ9H5uX0T1st4orQCixAQ%2FueP%2BfJO0PrHw5qqbjA1tv%2BTl4dcByqSYsExl%2Bvd0equlu7QkJVHlSsS1MB%2Bk30PUgg%2BnFvnsxtjufzS%2BGEjpklOdGI0LrwGX6U2n5KN1f4y2L%2Fkx93GrmSb8itipVwJdW%2Fk0tm93X3wNCNXqPUBQ%3D%3D', '2023-12-31 21:10:13'),
('test2', 'test2', '토끼토끼', '2003-04-21', '황소자리', 'images/profiles/2056ac61-00de-4241-a880-ba993ef14dd7.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/2056ac61-00de-4241-a880-ba993ef14dd7.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733323676&Signature=sKO%2FU1xtOMwchmH5G2oSGMdRR7zVGVk05Sw3iwyxTyLlRWt%2BLAHKE4BztzPr5bjkwWG1vfR7k%2FKZ%2FmHXvVnEMbS09csgWu04RPoOtGkvRQIdW0JgkOqGEr3zddAq1IsMzuwIy3zQyFBafQdvWMSJRvvQlARv9ldvwuSbm7oMrt9Px5Ld8JjflDoY%2BLUqenIaYQkjkyk6myvhkCHvO0S8TZT6S24BENLR7eBJE1z4tDenq0XqWqUA989ndrcA4P0O2hkP9oAVcY%2B5tCjxwDYzLZ3sSWOs8opGCecEV4XXMi22OAf7ctySzHaUk4p8GmdQwZqKwrnaa9CMl6%2FeKOJuZw%3D%3D', '2022-10-21 16:12:12'),
('test3', 'test3', '응애84', '2004-12-11', '사수자리', 'images/profiles/f734246e-9113-46f3-9a03-932c83081007.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/f734246e-9113-46f3-9a03-932c83081007.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733323704&Signature=MOX5eCj6TqDb1prPqRa0Ux19Kn1B9C659jTLEERzJuL2Ki8%2FEjK4OcM%2FzVDGEdhCv71FZq%2B23kjbhxQslAAw%2BYxBr%2B2L4k%2Fwzqp4ojQ%2BktY%2F2MD2zGpRmFxSVcl%2FmZdeROvxjxtIZXuLTZd6D5pl8YQKEG5UBQz2u9lyKWplzimBZV62jo9DY07Zh5SY2Q3QDxf7H41HBLDKwD4HC3devD7azEYSM4B9eyng4W1s%2BqFspie2hr3Me2ZmAF1WKmUT5X57oH2t3cpfAecg8jGG5CHswAiowf4cmkpb6PlW%2BrNLhTWbVfwfBDtfr3sORbqk9pFMspbawa0Qke%2BHj3MNmA%3D%3D', '2024-04-29 07:03:32'),
('test4', 'test4', 'glasssss', '1989-03-01', '물고기자리', 'images/profiles/a04643ce-e84f-4380-99db-99e3c5b294ad.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/a04643ce-e84f-4380-99db-99e3c5b294ad.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733323757&Signature=cLWRdUxGYo6CEekDR6KtR5pupLfO8jRCv5MVQhm4KLoD1LAWTZPFgoZwkquKDOLPQW%2FtWQV4sI4b0IiGlPJEFyj%2Fkkkwr%2BsU0LQmIxZIKu7Y0cP87or%2BU%2FNQYH0kF9DUyhHHsJqG%2BpF3FTaKNr4pl%2FPjgqQGg77hrgSoIOYOaN%2B7q3XndUKv2MZjcDQDIKaVatEgmmYzKDCpYc3wstfm0iPuE0p5DTNHyBktx8IqjY0WnmsiUaVXNDzCZXnKDjKWp70R2V%2Bmpn2eORiv4agieEsGtKt1VBvAtLt%2F%2BkZjqR9XZxvuJwPpoKLl7DJ5oz%2BRIleeILPXOcrYCYBZuDZW7g%3D%3D', '2021-01-02 22:39:31'),
('test5', 'test5', 'king', '2006-01-05', '염소자리', 'images/profiles/dc719713-24b2-456e-ad87-049d7aeb9839.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/dc719713-24b2-456e-ad87-049d7aeb9839.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733323787&Signature=SPpldF54Fq%2BO%2F%2FkHmYJi1odvkeyRi6Ir3o2BQzxmBixry6LU5QCwL03GSGRMFaDQ6NIQ2xVx%2B16o066Q%2BhHN1OT9dCdliUMIYxyx%2BL51jfnv5DBN9LW780y9xDTf2YaNlNb445Mdip5gB02wblHLDqWCNT6FnBxsstGfmzT8UpwdVWW1VqoGY%2BkOhYU2KyU3yjWXPSDW%2FAADznrDQIcpoe64ZOpLaAQvK2mXwYCORptl9m6kz%2FCg6pQ%2BIGn2q6LeQ1gxK6emuXC%2BrYEepj7PNHNOwko3oXYN2M0KZupOLqNFLZt4b7Id0YzWj7j3AlY4aJJol4W9R1SjTHpZPakgDg%3D%3D', '2022-11-03 10:23:12'),
('test6', 'test6', '농담곰', '2000-07-15', '게자리', 'images/profiles/03f3105a-7a10-4dfb-82e1-d80d71a9c5d3.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/03f3105a-7a10-4dfb-82e1-d80d71a9c5d3.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733323821&Signature=T%2FUeNfYm9tEL5rVNt1TAXeEanw1%2F%2FzVM6RHNd8VZ55B67z6XSB%2B5o8HIINuncLpjaVBZMlw3pvDigqIMpMPFoI1vXegePBhGvnef8bNA8xW7ryLZ7oUopX6Mdp0BYUaLqaYF90R1PumDC4cxqshmDiKAFwJNpFdanz8WYrAfyq95SjzFX0O39VxzlV5GB3unBbb8Re3ZRfo02SdHWpwWbTbcZsdd3iD0V9LIMXzgnO%2B%2FiCBWdKEO25o5Us4SgMTH0o%2BdQsT9jDAYZB%2BXzJ5E9uIRtNZ3Ch9cWvrih%2Fojf8VE5PtIukBe2%2Bx1xl4IZMvpvjYkljRX6tDPBk44Yt8pvw%3D%3D', '2022-03-23 11:13:42'),
('teemo', 'teemo', '티모대위', '2000-01-01', '염소자리', 'images/profiles/2153b147-119d-433b-8429-13fb4ebf99c1.png', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/2153b147-119d-433b-8429-13fb4ebf99c1.png?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733404395&Signature=St6ox32toXDLxlRMN7r1eHEee%2FUpbi6yDQ0CizqpQ7tpSQJvvrLOv3QzRkgKsMiMEqOUXCYzEAw6VSWyE%2FlpQe8ig41X58EQsaylmXEMHV1PMUVnVXMAqKxUwQ%2B%2F5PGj8JtNgJ%2BbvFV2FyPHSCdnv5bmkf3wuFNUBAgRdgcQ8Gn%2BL%2FneWK4e%2BS54k%2Bo%2Bh5KYq%2FlgROjPHmL3JuW9ZU9S1X0XYNL9WhWayVJZWp373fGtzG09aROOxEb5Jx5RVZtSAZV8sig4xFBoa4LyaVgayE4lJ8e6wBaaVWAV5v8g3wmvDNlCL%2BUQ1ZPHf9cGrf0Mi9OIL2TZYlUlp8ynrZtNpw%3D%3D', '2012-06-13 19:23:42'),
('OiPKL', 'OiPKL', '오이시러', '1998-10-10', '천칭자리', 'images/profiles/a2a6c12e-d878-45b9-ab6e-327f382866f6.png', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/profiles/a2a6c12e-d878-45b9-ab6e-327f382866f6.png?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733400119&Signature=KrMJtJjuo5XOmfVUpwTmtUxoWEfhuNNW0NRhwG4w1epCLorL%2FkWazrko6IkU6L9iX9dX8%2F8k8iX%2B5yUi3C4%2FQNAcxWaz4w3Bxux6zTsIvMsUoL%2Fi79PzLNX6mhnx8RWuengfxNSaia65bt1ha4YM5fx4QpfUqYnZg%2BnAv8C7pzaPzr3l%2Ff7m2sISsCKUNjyw9eIYwgvymxLVquaZH5o3GhZigbKGtiW9q%2BMa6RM7IHxBYRumzGsbYpjZP%2BF0gt23FfVMnBbT53CYNn3AzLJeCeWMe5yuVhJUbxrwgOp5MvR%2FAZ7PTgmSbtVysXKd4uGyKCI3kc4BK78diNSgElqD3g%3D%3D', '2013-03-21 02:33:11');


-- 테스트 게시글
INSERT INTO Board (user_id, user_name, title, content, view_cnt) VALUES
(2, '펭하', '설악산 다녀왔습니다!', '설악산에 다녀왔습니다! 가을이라 그런지 날씨가 좀 쌀쌀하네요. 등산할 때는 따뜻한 옷 꼭 챙겨가세요. 낙엽도 멋지게 떨어져서 가을 분위기가 한층 더해졌습니다. 정말 예쁜 풍경을 보고 왔어요!', 999),
(5, 'glasssss', '썬글라스 자랑 툭', '어때요?', 6),
(9, '오이시러', '오이오이 세일 중!!', '삼마넌!!!!!!', 84),
(3, '토끼토끼', '영-차', 'ㅇㅅㅇ', 393),
(7, '농담곰', 'Yo this is insane lol', 'Yo, this is literally insane lol. Anyone tried this? How the hell is this even possible? Hilarious as hell 😂😂. I’m legit pissed off but also dying laughing 😂. Who the hell came up with this? This is wild, man!', 5),
(7, '농담곰', 'Helloooo', '안녕하세요오~~~~', 7),
(1, 'admin', '관리자입니다', 'ㅈㄱㄴ', 111),
(6, 'king', '내 패딩 어때요', '어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요? 어때요?', 4329),
(4, '응애84', '찰칵1', '차차찰칵', 123),
(4, '응애84', '찰칵2', '차차찰찰찰칵', 234);

-- 테스트 게시글이미지
INSERT INTO BoardImage (user_id, board_id, file_name, file_path) VALUES
(2, 1, 'images/boards/f8ecddd9-83ac-436f-8d9f--- c06065427840.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/f8ecddd9-83ac-436f-8d9f-c06065427840.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733321989&Signature=UZWYzCBGjqZKM3RvpkbCvN1N9asvPfqlyYfRbYhQm%2B3W968yjeva4UoDgrvUweIDcvGpJNaBXN%2FTDQOphoiwCBBrBPOAKP1%2BgEsHQ2hC%2FBm%2B6vzYuWkdSSu%2BylWypd9XaYWDEMkB%2B10lfesA9cOBuVKnrK6HmVZGtFS3DngEavUhKQRM2fRsFFvANIBDZen68s9gdNk0TbiQTK8uE%2BE9twdXgkR5dqfYn6j0HX0nYOSrfIWdijssao9zB2sfbJzLf%2Bp1rnysGVr3PuGHYre3lkbANcd0jRDoBJTC79gPv1P1Z1KWP8i0p9%2Bd7Mg1Uzt%2F4X4%2BE98LEjWyudWmb7kKsw%3D%3D'),
(5, 2, 'images/boards/8f5a5e95-3dac-4d90-8670-74d6f3e9ef43.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/8f5a5e95-3dac-4d90-8670-74d6f3e9ef43.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322034&Signature=SChvDNkJSM%2FffO9xIMSCPgRSIN%2BrEJUZOQ7a06aFU9UAP%2FHafobAa2CWUwgASrTBVQcBcivj0YfXDJ08LWOsv7i7gOBSrex4zdDUfhkTOotEojDp26CEB1SyPu%2BY%2Fh7A%2BULcr7wvmLsi0gZJTvsrNkQuzaKHK8R3UkW2Vvbk2zkFXmroN7V3TXyPjpb7rVOq83i7BYUNy%2BxOYJyIZG0myZ7Q2jb60F30YxIU18n9SFqcJDyY12paEZG%2Bb%2BpOcBdjc1Xm0n0SMX2WcinMVfvOlFHa1%2B6EU0M0tJL%2FCZiIMcHjJnFWxG%2FdhtFVUG3CzhV6ePlKd%2BTxxZpAocZuU3K8WA%3D%3D'),
(5, 2, 'images/boards/80178aac-6a34-4fa2-8c21-9fb9db9d4921.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/80178aac-6a34-4fa2-8c21-9fb9db9d4921.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322035&Signature=G0gE5aI0zNYh7NXWqZ69UWYUpyc%2B%2BQXumw9WEeJoxUNfjZ8LoG4q3AYUrPPztomXLdTFt9BV9v%2Bw8RJDRWhIzLMdXfL568NgsLTAKOAduQ%2FqG4qyFLh22Mem4LEuOdmKfI6e9dSjZ9VfRx%2BkbXEgHMeTRun1uVSP7f0BgXbreRdzPa3pU9nEpVztWDNBnWashGlCTXQqGUCsj1ZRSTOmfgdynm3rVRgTynkdNRn1JMDWwOx7bJ9%2BuWz4p54OqiMTheLVnDvXVEMtRBlecA2F69MFt5sr3gflg98m48AFZRSrB4%2BNcSbcD4PBn1TKs4JH9OOogW52aiJx3KKlF0KSZg%3D%3D'),
(9, 3, 'images/boards/e21f9d72-d768-424a-892e-354263d35081.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/e21f9d72-d768-424a-892e-354263d35081.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733400680&Signature=RUdTfbas9ORf%2BFDIIQTVpQrMijFfqyg0TX61gV2g15%2BX%2B0lNNJCl8sXQJEJmQsduSGCatmXGRAQjJvh2Nk9DdLGOxdkr0%2FJwDxqWSHleiuz4j%2FdwSNdEW4LMR%2BPovFxuap2%2FLnj97qKgMvqWYU0VI1Tv9Ys4mq%2FAtIUf7nrHq1myMHQf0GlZZL8xsF04USHCuKtXMt59HKnSxEfxk4hTUg0FmVKRiC4U2WGQRRDTFCDhZHvTaank6KoTEv95JdRzWJubd28nAbhrMax%2Bhq%2BXzYamAWvus78ph79aCsgDpRzA9vdP6F88M6qG2YkQyJBJR6R%2Bkx9O4Yg9UR6BNMO7aA%3D%3D'),
(9, 3, 'images/boards/3d317a11-b61d-446b-9a8e-eef30807bb60.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/3d317a11-b61d-446b-9a8e-eef30807bb60.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733400680&Signature=TKhu%2BV8iJCl8mfLSR%2BrbfJw6eHGPvIVxytl0cMTzzjEv8WWSGfyQNWPTbq0oVOWDIML16iEUdZhXDfp0wZ8KGs6BU7UuO1EuagmdaEJ83IGtm0WqJBnchKnIq7nybzUyoobiZr5vsj9A06IjrL1xor2afHcCfaA%2FQfhnge4BOGeL3Mg6HRvyFUpS%2B2U3x3IR3Gtw8crOL0f%2FPuVwV6MWpi%2FWrtS9kc2mDPsC1Ti5lT1ukCi2X2Pm8Dx0cHEcJWN5dKeyv%2Fj%2FwLCCQvnLFO0koPABEqn7885uCiS%2FLOD7ljzJap7Wm9T%2BL80yCjkz0Zh6svGJlFV4BjnETl%2FZLvWGOQ%3D%3D'),
(3, 4, 'images/boards/0de6004d-df50-4518-87a6-5deeb5565226.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/0de6004d-df50-4518-87a6-5deeb5565226.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322872&Signature=SQgRqrrsOq3Eq0puQAWeOnYYZFPiVGH0dcCuEd98EUbjLQA2glM9fqLsC9GJ5yQuf3Ilh7GggFOy43tnBobAPzLv4BX9kPORuvUOS1Pys03Lr72etSJBvFJdJt6e8MhYse8matO3WSkvFbY113o0bNeHjNK0j2N%2BuFukto7I7xNHiiZ527K37iMazuZlUguGzCo6BatqWv8KlwMAVzOIQ%2BO9G4exLy6Q%2BfvVGqJFHg0uLh5FtBSazDgwWjTqE6TgZtklUxtyKvoAB%2BoWG42upTJEpe6Z1cDFt%2Bgo%2FaEK9k%2FMrlKmhcDpBsE4AkTg3iTRYOuIUZkBXQCgd9H9i%2BUctw%3D%3D'),
(3, 4, 'images/boards/10adb890-6638-42a7-892a-77d906bd8c6e.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/10adb890-6638-42a7-892a-77d906bd8c6e.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322874&Signature=kbOgdISIwhaw3zUci1WKZ0l5oUcas1JKjSUoMyCThU9e9SYfG2Va4ULxXncsESgcVqumEfNNAPWcBiQ3I1oM7h7nkbhGHOHzbsIlmJXCEjWuu%2FhICxWhBXFkDD%2FlskbHl%2F%2FqJVNHe46qNn96%2BRfZgBr9lBVjuWvIIgfOyysQMJymit7diPIq0vZODqB4K6eHX61JamaYAlWVEaq3Kih6R8fKIMVLYrHWiC756zmCtZ1FX8GBgWXmRyiiQxw%2Fs11h%2FPLEsqsVaBeqRXQteVcpevjMHn2OYhJ1KYyLZS4o60%2B1uiNFjxOA1LdOCgMro0emM5k37mKZAUopzY1z29fvBA%3D%3D'),
(7, 5, 'images/boards/50cc4cb2-7fc9-40f7-b5a0-e50a1d8b2c53.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/50cc4cb2-7fc9-40f7-b5a0-e50a1d8b2c53.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322571&Signature=HaJBrj%2Fe2p6UMwlNSFeyQl2bo%2B3UTV5QKQ1eJXUa8wz7VDNn%2BPkHzED9j0eTte5OlIt83TIR6axM%2FrGV%2BAd6r9M0rLiz9u6JbKfImtA6b362ZCi0T%2BndsT0HPiUv2plsj%2B%2FFCvuVvOEKQBK5VV%2BCDzWYX1i39JmsSMFeUVxiR2UezdwyJsdE6fDSlxbEiTvHkYd4YwTUsuIM%2BIl8TjhnbTB%2BY%2Fjbjr7wXpskjlhqbv%2FQcIW0GtXm4Rnb4TbacH1sXVls6ANVs7g0MEA8Ual76sddEG5biWkjvQpaPGstu7ipVCa3HbKrESL8aTxo9eqk1q2ppgZ1CZq65qEj2Pq3wQ%3D%3D'),
(7, 6, 'images/boards/a64f6353-37a3-4ccc-bfc5-4172751eafb6.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/a64f6353-37a3-4ccc-bfc5-4172751eafb6.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322585&Signature=Dq6DybhHDML8z8BhrwHsh2LEbbKY78jO1kkfMU0wdItt%2BFxzYE5MCiK24BzzEU1vnRFww4W1hGSVpVWAfezJuy0Ct2eC8RFwqpqvnDE9YNdTgor%2FXquYlCDatlJ0MNKn5oyLW4JO2Vw4ZyA8t41UhI2uG2tSTpQvxIUbKagQiwnPnjDV2RDiDsyQ7X6qrVtxsm2vyu0fCFaozr69S1zWdJxwcezes2OE5S3jsxoqB56FOxXbUvDZQD2ZzSW2HuEfe2PHjoPfOWnb0zUn%2BOZV2E6iLBVGEcBDPYS4y%2FBogOVDpAOrZe4bfQ7NDc%2BShvPbyhhNgkJaI5ZDJekrijQ3sQ%3D%3D'),
(6, 8, 'images/boards/d69fd3ad-0a86-4505-8802-d265cd6c2168.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/9a480ac3-7adb-44db-82fa-e618c313f411.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322491&Signature=sW3CqAMT7Tf2bVTuAgtljjiwf%2FWW64tACYSj5oX2vMFczQbW7crsUmDbh4yDdGI0IG2wDVGAyqISGmHtoP%2BmF5XEQ9zswWxneQ2BP%2BlPLDnJdjNZUa1fxdJSTqB5wBV%2BuihiB0%2FoKXqqrasoj%2FaUJYplpkIvyGVvvQRlMaINbbfyZAYcXj09XBK53t%2BbN%2F%2FSku11ugz%2Fku1anV7y4425KsY3iPuw%2BuqVS2xqHCY3ZMuQsHegPl2YeSmyKKIe3rebTAFGWlARoc4bv5FWpPHz5N8Gk%2FTLdeNfNFrn%2FgURd7LPNRMx0DZ0e61Q6A0zRGvckjZpwF0Zv1cc8PPErCtTKA%3D%3D'),
(6, 8, 'images/boards/190ab187-e776-4b49-9ba0-536897f51296.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/190ab187-e776-4b49-9ba0-536897f51296.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322491&Signature=xU3uhZCLPkFWdaQ4GiJa25eIpGMN2u9UkmSGzE58V%2B4alhmHYGfQixu60YqPavDUBQtHHJwfS5CsvnykvpSjcmgIF0piWzz81hCG7tUCTbp36Fop2DJL%2BdLkQ%2FOtsNXql4dJmUD6CTK8SnbxyajKD%2FrafQM82%2BOCNOOVTCPDGJZvei1wOZV1%2BYlXeoUqg6OQX1HbjMhDV2%2FvXlGSM5yFRrZ7A81DSv%2FQg%2FXSuCB1VHRrXp%2BQmG8tidmR9be6LMIjE%2FmXyZ77X4yuw4goL3ghM8BR5CLMRNm9LotLxkr3VTg9I%2FMXFh1Z3V7E8iG4JoQKlp0is3wDuVEaB%2FtogFfiRg%3D%3D'),
(6, 8, 'images/boards/38cf23a6-7215-400b-aa08-9a8750878c7b.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/38cf23a6-7215-400b-aa08-9a8750878c7b.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322492&Signature=JJu5Y4rokRSzSfgCeZ7K7VJGlN1HhaIWV%2Brg1AdbzkU1%2FTtPcDIgvyVSHJnp0O3ROCxPQsQGok373BK5adPKZvZ95lLLhCZClcfxDFJZ7z%2FEqpH0mdKSDL32uCYLdcvqA%2BWptdtfQIOfaORaHRM2EvtV1bqqX%2F6I6HtXuYPi9j6nP0rlR9Bi3cog9lwKQrFDgyv8PVxndfoMCFubq1ici5nmLz0r5lhJIvKvqu2eeaGUCa7ghkx8Tx%2Bgvws9j4kNYoFGhsJc5bg5aKo%2BkXOozspXzWgo7552zD52IjEDJIE1dhBywVaqolaAMBWTxO%2BsJ0Z18nA%2Bg64tYjNdw8FEqA%3D%3D'),
(4, 9, 'images/boards/9b0e5041-abea-48e6-813d-ba4d0d2647b8.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/9b0e5041-abea-48e6-813d-ba4d0d2647b8.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322928&Signature=Oxp%2FQlpwxtrTqLQw43wjY%2BODPBSH06zrWh2l8rhQRiOih7v2jx3fwVMdj5pOB%2FBD8YTiFQoDCV%2FBas2kk%2FC%2BuJfd3Hubk029AUjWo1yYOOcVEl2zExzBC2fznnfgLt1qkYZbVOVr3zXBUsfZPpw1jnGksySqHiZ6FJqMOwjBrLQSqDZV%2FbMHuKbnAWLT2NRwO1D7lWg4KIohP%2Bamg6916VQ5Ixh3%2B9x4DTOBKz03uyERYun1fqUEr0FtDPjlDMA06LGI4EEC3lGkW%2FZeb2uzZF3irlEQQ3q8UjEjP8JbmWBLT5mn%2BaJMYpvPiniQnpCJqAuZofqVYaBY56f0dGDZbw%3D%3D'),
(4, 9, 'images/boards/7550a8c9-7079-4641-9183-3e1fad3fa092.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/7550a8c9-7079-4641-9183-3e1fad3fa092.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322929&Signature=vy%2FBFwja5lvcrjqo%2FtpR7%2BxBaDRY8Mw14ZzVrLsYIxBINpYFSyNqZB78iTGxE6ZvIiltLw1eI5%2BbbkdPibyZalps49jYcbgMLjXWSB7Pke9Iw8tpSgR6WD%2BWfi8m74OaF9u2UyboEwFbQaDa64mP%2BW3xDHikDr6lkDcSj16mwU5l%2B2ek9fSqZfnHx5UQ4HWsDZ3FvaX%2Brj09AJWnQBARK2%2FG18JnqdG5lVUI7poKjYmpjElRqEeAV%2FEhMQUIosFBu5LvQniq0EfQMbOuCO28umJ8SzVX98bIvah8UDf2%2Bla7l0Tp%2BlFKiDpSLypWcKN5sOw0X%2FatWJS2hAVgRJEyhQ%3D%3D'),
(4, 10, 'images/boards/653f0b3d-a64b-4acd-9da1-a7ec7bd000cf.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/653f0b3d-a64b-4acd-9da1-a7ec7bd000cf.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322931&Signature=IERabGGjZlEkYFOmqHcrqRgfEbS965li%2BPowW%2Ff2sEPI7CI6r%2BT3kffnmk3zyVCFvZHcg%2B4VSx0F6j8K23t%2BqRs9EbTX6n9DccQHQXiCVKRM5oj8GCY%2BmqFGjBwjJIPvf9uBMulyEccybJzII2%2Fi4xt6%2F2VQytyENiZRonOazuUM%2FCzn6vO%2B%2FUQ%2BVrzDrmrpa7SeQLZuJ2AE1zIdifRVqMu7Qx%2Bstj8fE%2FeOb4ykJmgC%2BCnQYGfiSHjttxrZ90JnmvsIUhdu8BruTKrOnmRu0ixs75TD61wNXGJKHtHQg4oIy4wl64bnRI1KPkGHPvexvuShkV56PSsOX6VRQ%2FI1RQ%3D%3D'),
(4, 10, 'images/boards/e71dffee-9f3f-4838-9f7c-546582e95807.jpg', 'https://storage.googleapis.com/whatsyoulook-11c33.firebasestorage.app/images/boards/e71dffee-9f3f-4838-9f7c-546582e95807.jpg?GoogleAccessId=firebase-adminsdk-9r4um@whatsyoulook-11c33.iam.gserviceaccount.com&Expires=1733322932&Signature=h6lsv6IRKI24tk0t6pyE18K%2BAmn3UW8upEyGUtHXNsSPI%2B9ZJ4KEWXY0tldDWGRAzqr3hyKX1L0vMzFYIIQYM3hOGcXnPv5N3WPgOd6%2F7nCgZKfJ6TkuVYjLVhMC6RI1S4QxA9sv95XpHasgzrrPVYflVUzBWRAClj9gzaVZtKuCNI8yvKdvu6z%2BmLp1QN2aAnJX3uKF0wLJdMtInlYeV%2B2AXNBXDaKPsyIHAO360n6eJatzLrw10vbuWlCQVadJohW0Jq%2BVfD1y890Qvbd%2BMVang7W285Tg1SrjnyxmIKecDXm%2B%2Fyt4z0sOCelq8F3GrN%2BqgWrN77hmuGGVQU3vvQ%3D%3D');

-- 테스트 댓글
INSERT INTO Comment (user_id, user_name, board_id, content) VALUES
(3, '토끼토끼', 1, '우와'),
(4, '응애84', 1, '우와'),
(7, '농담곰', 1, '우와'),
(8, '티모대위', 1, '우와'),
(9, '오이시러', 1, '우와'),
(6, 'king', 2, '굳'),
(2, '펭하', 2, '별로'),
(5, 'glasssss', 3, '오아이오아이..'),
(9, '오이시러', 3, '헉'),
(7, '농담곰', 4, 'good'),
(8, '티모대위', 5, 'm(=^오^=)m'),
(8, '티모대위', 5, '도배하지마세요'),
(2, '펭하', 7, '네'),
(5, 'glasssss', 7, '네'),
(3, '토끼토끼', 8, '별로'),
(3, '토끼토끼', 9, '찰칵');


-- Zodiac 테이블
INSERT INTO Zodiac (name, start_date, end_date) VALUES
('양자리', '03-21', '04-19'),
('황소자리', '04-20', '05-20'),
('쌍둥이자리', '05-21', '06-20'),
('게자리', '06-21', '07-22'),
('사자자리', '07-23', '08-22'),
('처녀자리', '08-23', '09-22'),
('천칭자리', '09-23', '10-22'),
('전갈자리', '10-23', '11-21'),
('사수자리', '11-22', '12-21'),
('염소자리', '12-22', '01-19'),
('물병자리', '01-20', '02-18'),
('물고기자리', '02-19', '03-20');

-- Aries (양자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('양자리', '오늘은 도전적인 일에 적합한 날입니다. 새로운 시작을 준비하세요.'),
('양자리', '직장에서 중요한 결정을 내리기에 좋은 시기입니다. 자신감을 가지세요.'),
('양자리', '오늘은 조금 더 신중하게 행동하는 것이 좋습니다. 급한 결정을 피하세요.'),
('양자리', '가족과의 관계에서 갈등이 있을 수 있습니다. 대화를 통해 풀어보세요.'),
('양자리', '건강에 유의해야 하는 날입니다. 충분히 휴식을 취하세요.'),
('양자리', '금전적으로 좋은 기회가 올 수 있습니다. 투자에 신중하세요.'),
('양자리', '사랑하는 사람과의 관계에서 작은 오해가 생길 수 있습니다. 서로 이해하려고 노력하세요.'),
('양자리', '창의적인 작업을 할 수 있는 기회가 옵니다. 아이디어를 실현해 보세요.'),
('양자리', '오늘은 새로운 친구를 사귈 수 있는 기회가 있을 수 있습니다. 열린 마음으로 다가가세요.'),
('양자리', '조금 더 세밀하게 계획을 세우는 것이 중요합니다. 작은 실수가 큰 문제를 일으킬 수 있습니다.');

-- Taurus (황소자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('황소자리', '오늘은 새로운 계획을 세우기에 좋은 날입니다. 목표를 명확히 하세요.'),
('황소자리', '금전적으로 안정적인 시기입니다. 재정 관리에 신경을 써야 합니다.'),
('황소자리', '오늘은 감정적으로 조금 불안정할 수 있습니다. 차분하게 생각하세요.'),
('황소자리', '사랑하는 사람과의 관계에서 진전이 있을 수 있습니다. 솔직하게 대화하세요.'),
('황소자리', '일에 집중하는 것이 중요한 날입니다. 방해 요소를 제거하세요.'),
('황소자리', '오늘은 집안일이나 가벼운 정리를 할 때입니다. 주변을 정리하면 기분이 좋아질 것입니다.'),
('황소자리', '건강에 신경 써야 하는 시기입니다. 충분한 수면과 균형 잡힌 식사를 유지하세요.'),
('황소자리', '사회적 네트워킹을 확장할 기회가 있습니다. 적극적으로 사람들과 소통하세요.'),
('황소자리', '어떤 일에서 승산이 보입니다. 기회를 놓치지 않도록 하세요.'),
('황소자리', '사소한 갈등이 있을 수 있지만, 큰 문제로 번지지 않도록 조심하세요.');

-- Gemini (쌍둥이자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('쌍둥이자리', '오늘은 평소보다 더욱 창의적인 아이디어가 떠오를 수 있습니다.'),
('쌍둥이자리', '어려운 결정을 내려야 할 상황이 있을 수 있습니다. 직관을 믿으세요.'),
('쌍둥이자리', '사회적 관계에서 중요한 일이 있을 수 있습니다. 상대방의 감정을 배려하세요.'),
('쌍둥이자리', '금전적인 기회가 올 수 있습니다. 하지만 신중하게 결정하세요.'),
('쌍둥이자리', '오늘은 직장에서 눈에 띄는 성과를 거두기 좋은 날입니다.'),
('쌍둥이자리', '기대하지 않았던 곳에서 행운이 올 수 있습니다. 열린 마음을 가지세요.'),
('쌍둥이자리', '오늘은 친구나 동료와의 관계에서 조금 다툼이 있을 수 있습니다. 대화로 해결하세요.'),
('쌍둥이자리', '사랑에 있어 작은 오해가 있을 수 있습니다. 진지하게 대화하세요.'),
('쌍둥이자리', '건강을 챙겨야 할 시기입니다. 운동을 시작해보세요.'),
('쌍둥이자리', '오늘은 무언가 새로운 일을 시작하기 좋은 날입니다. 시작하세요.');

-- Cancer (게자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('게자리', '오늘은 감정적으로 평온한 하루가 될 것입니다. 가족과 함께 시간을 보내세요.'),
('게자리', '직장에서 중요한 변화를 맞이할 수 있습니다. 적응력이 필요합니다.'),
('게자리', '사랑하는 사람과 함께 소중한 추억을 만들 수 있는 기회가 있습니다.'),
('게자리', '오늘은 건강에 유의해야 하는 날입니다. 스트레스 관리가 필요합니다.'),
('게자리', '금전적으로 좋은 기회가 올 수 있습니다. 적당한 투자 계획을 세우세요.'),
('게자리', '사회적 관계에서 새로운 사람과의 만남이 있을 수 있습니다. 열린 마음으로 다가가세요.'),
('게자리', '오늘은 가벼운 운동이 도움이 될 수 있습니다. 산책을 추천합니다.'),
('게자리', '조금 더 차분하게 일을 처리하는 것이 중요합니다. 급하게 움직이지 마세요.'),
('게자리', '오늘은 새로운 지식을 얻을 수 있는 기회가 있을 수 있습니다. 학습에 투자하세요.'),
('게자리', '사소한 갈등이 일어날 수 있습니다. 대화로 풀어보세요.');

-- Leo (사자자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('사자자리', '오늘은 자신감을 가지고 계획을 실행하는 데 좋은 날입니다.'),
('사자자리', '금전적으로 안정적인 하루가 될 것입니다. 지출에 신경을 써야 합니다.'),
('사자자리', '사랑하는 사람과의 관계에서 작은 불화가 있을 수 있습니다. 대화로 풀어보세요.'),
('사자자리', '직장에서 성과를 인정받을 수 있는 날입니다. 계속 노력하세요.'),
('사자자리', '오늘은 개인적인 목표를 달성하기 좋은 기회입니다. 집중하세요.'),
('사자자리', '사회적 네트워킹을 확장할 기회가 있습니다. 사람들과 소통하세요.'),
('사자자리', '건강에 유의해야 합니다. 균형 잡힌 식사와 운동을 하세요.'),
('사자자리', '오늘은 변화가 일어날 수 있는 날입니다. 변화를 받아들이세요.'),
('사자자리', '친구나 동료와 함께 즐거운 시간을 보낼 수 있습니다. 즐기세요.'),
('사자자리', '오늘은 여행을 떠나기에 좋은 날입니다. 계획을 세워보세요.');

-- Virgo (처녀자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('처녀자리', '오늘은 직장에서 새로운 기회를 맞이할 수 있습니다. 준비하세요.'),
('처녀자리', '금전적으로 조심할 필요가 있는 날입니다. 지출을 줄이세요.'),
('처녀자리', '사랑하는 사람과의 관계에서 조금 불안한 느낌이 있을 수 있습니다. 대화가 필요합니다.'),
('처녀자리', '오늘은 개인적인 시간에 투자하는 것이 좋습니다. 독서를 추천합니다.'),
('처녀자리', '건강에 유의하세요. 스트레스가 쌓이지 않도록 명상을 해보세요.'),
('처녀자리', '사회적 관계에서 갈등이 일어날 수 있습니다. 조금 더 배려하는 마음을 가지세요.'),
('처녀자리', '오늘은 가벼운 운동을 통해 기분을 전환하세요.'),
('처녀자리', '금전적인 이득이 있을 수 있습니다. 작은 투자로 좋은 결과가 나올 수 있습니다.'),
('처녀자리', '오늘은 창의적인 작업을 할 때입니다. 새로운 아이디어를 떠올려 보세요.'),
('처녀자리', '사소한 일에 신경 쓰지 말고 큰 그림을 봐야 할 때입니다.');

-- Libra (천칭자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('천칭자리', '오늘은 중요한 결정을 내려야 할 상황이 있을 수 있습니다. 직감을 믿으세요.'),
('천칭자리', '사회적 네트워크에서 중요한 사람과의 만남이 있을 수 있습니다. 열린 마음으로 대하세요.'),
('천칭자리', '건강을 챙기세요. 가벼운 운동이나 산책이 도움이 될 것입니다.'),
('천칭자리', '오늘은 감정적으로 불안할 수 있습니다. 차분하게 생각하세요.'),
('천칭자리', '사랑에 있어서 새로운 시작을 할 수 있는 기회가 있습니다.'),
('천칭자리', '금전적으로 조금 더 신중해져야 할 시기입니다.'),
('천칭자리', '오늘은 친구나 동료와의 관계에서 조금 불화가 있을 수 있습니다. 대화로 풀어보세요.'),
('천칭자리', '오늘은 창의적인 아이디어가 떠오를 수 있습니다. 이를 실현해 보세요.'),
('천칭자리', '오늘은 집안일을 처리하기에 좋은 날입니다. 정리정돈을 해보세요.'),
('천칭자리', '사랑하는 사람과 함께 시간을 보내는 것이 중요합니다.');

-- Scorpio (전갈자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('전갈자리', '오늘은 감정적으로 강한 하루가 될 수 있습니다. 냉철하게 상황을 파악하세요.'),
('전갈자리', '금전적인 문제에서 중요한 결정을 내려야 할 시점입니다. 신중하게 판단하세요.'),
('전갈자리', '오늘은 직장에서 주목받을 수 있는 기회가 있습니다. 자신감을 가지세요.'),
('전갈자리', '사랑하는 사람과의 관계에서 갈등이 생길 수 있습니다. 대화를 통해 해결하세요.'),
('전갈자리', '오늘은 과거의 문제를 해결하기 좋은 날입니다. 마음을 열고 대화하세요.'),
('전갈자리', '건강에 유의해야 할 시기입니다. 과로하지 않도록 주의하세요.'),
('전갈자리', '새로운 계획을 세우기에 적합한 날입니다. 목표를 구체적으로 설정하세요.'),
('전갈자리', '오늘은 친구나 동료와의 관계에서 긍정적인 변화가 있을 수 있습니다.'),
('전갈자리', '금전적인 기회가 올 수 있습니다. 하지만 급하게 결정을 내리면 위험할 수 있습니다.'),
('전갈자리', '오늘은 창의적인 작업에 집중하기 좋은 날입니다. 아이디어를 현실화해 보세요.');

-- Sagittarius (사수자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('사수자리', '오늘은 새로운 지식이나 경험을 얻을 수 있는 기회가 있을 수 있습니다.'),
('사수자리', '금전적으로 조금 신중해야 하는 시기입니다. 불필요한 지출을 줄이세요.'),
('사수자리', '사랑하는 사람과의 관계에서 좋은 시간을 보낼 수 있습니다. 소중한 순간을 즐기세요.'),
('사수자리', '오늘은 새로운 일을 시작하기에 좋은 날입니다. 도전해보세요.'),
('사수자리', '사회적인 자리에서 중요한 결정을 내릴 수 있습니다. 자신감을 가지세요.'),
('사수자리', '건강에 신경 써야 하는 시기입니다. 규칙적인 생활을 하세요.'),
('사수자리', '오늘은 직장에서 긍정적인 변화가 있을 수 있습니다. 노력한 만큼 성과가 있을 것입니다.'),
('사수자리', '오늘은 새로운 사람을 만날 가능성이 큽니다. 열린 마음으로 다가가세요.'),
('사수자리', '금전적으로 좋은 기회가 올 수 있습니다. 기회를 잘 활용하세요.'),
('사수자리', '오늘은 자기 개발을 위한 시간을 가지는 것이 좋습니다. 독서나 학습을 추천합니다.');

-- Capricorn (염소자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('염소자리', '오늘은 중요한 결정을 내려야 할 순간이 올 수 있습니다. 신중하게 생각하세요.'),
('염소자리', '금전적으로 안정된 시기입니다. 재정 관리를 잘 하세요.'),
('염소자리', '오늘은 직장에서 중요한 변화를 맞이할 수 있습니다. 새로운 기회를 놓치지 마세요.'),
('염소자리', '사랑하는 사람과의 관계에서 작은 갈등이 있을 수 있습니다. 대화로 풀어보세요.'),
('염소자리', '오늘은 건강에 유의해야 하는 날입니다. 충분히 휴식을 취하세요.'),
('염소자리', '사회적 관계에서 좋은 소식이 있을 수 있습니다. 열린 마음으로 받아들이세요.'),
('염소자리', '오늘은 가벼운 운동이 도움이 될 수 있습니다. 산책을 추천합니다.'),
('염소자리', '금전적으로 좋은 기회가 올 수 있습니다. 하지만 지나친 욕심은 피하세요.'),
('염소자리', '오늘은 친구나 동료와의 관계에서 긍정적인 변화가 있을 수 있습니다.'),
('염소자리', '오늘은 가족과의 관계에서 중요한 대화가 필요할 수 있습니다. 서로의 의견을 나누세요.');

-- Aquarius (물병자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('물병자리', '오늘은 감정적으로 조금 불안정할 수 있습니다. 차분하게 생각하세요.'),
('물병자리', '사회적 네트워킹을 확장할 수 있는 기회가 있습니다. 사람들과 소통하세요.'),
('물병자리', '오늘은 직장에서 중요한 성과를 낼 수 있는 날입니다. 집중하세요.'),
('물병자리', '사랑에 있어 작은 갈등이 있을 수 있습니다. 서로의 입장을 이해하려고 노력하세요.'),
('물병자리', '금전적으로 좋은 기회가 있을 수 있습니다. 그러나 급한 결정을 내리지 마세요.'),
('물병자리', '오늘은 창의적인 아이디어가 떠오를 수 있습니다. 이를 실현해 보세요.'),
('물병자리', '건강에 신경을 써야 할 시기입니다. 충분한 휴식을 취하세요.'),
('물병자리', '오늘은 새로운 계획을 세우기에 좋은 날입니다. 목표를 분명히 설정하세요.'),
('물병자리', '친구나 동료와의 관계에서 작은 갈등이 있을 수 있습니다. 대화를 통해 해결하세요.'),
('물병자리', '오늘은 중요한 결정을 내려야 할 순간이 올 수 있습니다. 직감을 믿으세요.');

-- Pisces (물고기자리)
INSERT INTO Fortune (zodiac_sign, content) VALUES
('물고기자리', '오늘은 감정적으로 매우 풍부한 하루가 될 수 있습니다. 마음을 열고 대화하세요.'),
('물고기자리', '금전적으로 중요한 결정을 내려야 할 시점입니다. 신중하게 판단하세요.'),
('물고기자리', '오늘은 직장에서 중요한 일이 있을 수 있습니다. 기회를 놓치지 마세요.'),
('물고기자리', '사랑하는 사람과의 관계에서 좋은 시간을 보낼 수 있습니다. 소중히 여겨요.'),
('물고기자리', '오늘은 건강에 유의해야 하는 날입니다. 충분한 휴식을 취하고 스트레스를 줄이세요.'),
('물고기자리', '사회적 네트워크에서 중요한 만남이 있을 수 있습니다. 새로운 인연을 만들 수 있습니다.'),
('물고기자리', '오늘은 창의적인 작업에 집중하기 좋은 날입니다. 새로운 프로젝트를 시작하세요.'),
('물고기자리', '금전적인 기회가 올 수 있습니다. 신중하게 투자 계획을 세우세요.'),
('물고기자리', '오늘은 직장에서 좋은 성과를 얻을 수 있는 기회가 있을 수 있습니다.'),
('물고기자리', '오늘은 사랑하는 사람과의 관계에서 중요한 대화가 필요할 수 있습니다. 서로의 감정을 나누세요.');