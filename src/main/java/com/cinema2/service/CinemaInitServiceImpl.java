package com.cinema2.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.stream.Stream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema2.dao.CategorieRepository;
import com.cinema2.dao.CinemaRepository;
import com.cinema2.dao.FilmRepository;
import com.cinema2.dao.PlaceRepository;
import com.cinema2.dao.ProjectionRepository;
import com.cinema2.dao.SalleRepository;
import com.cinema2.dao.SeanceRepository;
import com.cinema2.dao.TicketRepository;
import com.cinema2.dao.VilleRepository;
import com.cinema2.entities.Categorie;
import com.cinema2.entities.Cinema;
import com.cinema2.entities.Film;
import com.cinema2.entities.Place;
import com.cinema2.entities.Salle;
import com.cinema2.entities.Seance;
import com.cinema2.entities.Ville;


@Service 
public class CinemaInitServiceImpl implements IcinemaInitService {
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ProjectionRepository projectionRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Override
	public void initVilles() {
		Stream.of("Paris","Annecy","Cannes","Trois-Rivière").forEach(villeName->{
			Ville ville = new Ville();
			ville.setName(villeName);
			villeRepository.save(ville);
		});
		
	}

	@Override
	public void initCinema() {
		 villeRepository.findAll().forEach(v->{
			 Stream.of("Imax","Cinema 12","DisneyCinema").forEach(nameCinema->{
				Cinema cinema = new Cinema() ;
				cinema.setName(nameCinema);
				cinema.setNombreSalles(3+(int)(Math.random()*7));
				cinema.setVille(v);
				cinemaRepository.save(cinema);
			 });
		 });
		
	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema->{
			for(int i = 0;i<cinema.getNombreSalles();i++) {
				Salle salle = new Salle();
				salle.setName("Salle" + (i + 1));
				salle.setCinema(cinema);
				salle.setNombrePlace(20+(int)(Math.random()*20));
				salleRepository.save(salle);
			}
		});
	}

	@Override
	public void initSeances() {
		DateFormat df = new SimpleDateFormat("HH:mm");
		Stream.of("12:00","13:00","15:00","17:00","19:00","21:00","23:00").forEach(seances->{
			Seance seance = new Seance();
			try {
				seance.setHeureDebut(df.parse(seances));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle->{
			for(int i = 0;i < salle.getNombrePlace();i++) {
				Place place = new Place();
				place.setNumero(i + 1);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});		
	}

	@Override
	public void initCategories() {
		Stream.of("Histoire","Action","Horreur","Amour","Futuriste","Fantastique").forEach(cat->{
			Categorie categorie = new Categorie();
			categorie.setName(cat);
			categorieRepository.save(categorie);
			});
		
	}

	@Override
	public void initFilms() {
		double[] durees = new double[] {1,1.5,2,2.5,3};
		List<Categorie> categories = categorieRepository.findAll();
		Stream.of("Annabelle","Fast And Furious","Titanic","Futurama","Batman").forEach(titreFilm->{
			Film film = new Film();
			film.setTitre(titreFilm);
			film.setDuree(durees[new Random().nextInt(durees.length)]);
			film.setPhoto(titreFilm.replaceAll(" ", ""));
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
		});
		
	}

	@Override
	public void initProjections() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initTickeys() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
