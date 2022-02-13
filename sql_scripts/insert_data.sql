INSERT INTO public.bikes (id, bike_name, cost_per_hour) VALUES (1, 'mountain', 10);
INSERT INTO public.bikes (id, bike_name, cost_per_hour) VALUES (2, 'track', 20);
INSERT INTO public.bikes (id, bike_name, cost_per_hour) VALUES (3, 'bmx', 30);

INSERT INTO public.users (id, name, budget) VALUES (1, 'John Malcovich', 500);
INSERT INTO public.users (id, name, budget) VALUES (2, 'Robert Nerp', 800);
INSERT INTO public.users (id, name, budget) VALUES (3, 'Van Darkholm', 600);
INSERT INTO public.users (id, name, budget) VALUES (4, 'Billy Harrington', 500);
INSERT INTO public.users (id, name, budget) VALUES (5, 'Victor Crumb', 600);
INSERT INTO public.users (id, name, budget) VALUES (6, 'Donald Trump', 300);
INSERT INTO public.users (id, name, budget) VALUES (7, 'Elon Musk', 400);
INSERT INTO public.users (id, name, budget) VALUES (8, 'Vladimir Putin', 900);
INSERT INTO public.users (id, name, budget) VALUES (9, 'Mister P', 1100);
INSERT INTO public.users (id, name, budget) VALUES (10,'Muslim Gubaev', 400);

INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (1,1,1,1,10);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (2,2,2,1,20);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (3,3,3,3,90);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (4,1,4,1,10);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (5,2,5,1,20);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (6,3,6,2,60);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (7,3,7,2,60);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (8,2,8,3,60);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (9,1,9,1,10);
INSERT INTO public.drives (id, bike_id, user_id, hours, cost) VALUES (10,2,10,2,40);
