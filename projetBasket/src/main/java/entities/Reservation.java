package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "booking")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;
    @Column(name = "booking_price")
    private double prix;
    @Column(name = "booking_quantity")
    private Integer quantite;
    @Column(name = "booking_date")
    private LocalDate dateReservation;

    @ManyToOne
    @JoinColumn(name="booking_confrontation_id", foreignKey = @ForeignKey(name="booking_confrontation_id_fk"))
    private Confrontation confrontation; 
    
    @ManyToOne
    @JoinColumn(name="booking_compte_id", foreignKey = @ForeignKey(name="booking_compte_id_fk"))
    private Compte compte;
    
	public Reservation() {
	}

	

	public Reservation(double prix, Integer quantite, LocalDate dateReservation, Confrontation confrontation,
			Compte compte) {
		this.prix = prix;
		this.quantite = quantite;
		this.dateReservation = dateReservation;
		this.confrontation = confrontation;
		this.compte = compte;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	

	public Confrontation getConfrontation() {
		return confrontation;
	}



	public void setConfrontation(Confrontation confrontation) {
		this.confrontation = confrontation;
	}



	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}

    
    
	
}
