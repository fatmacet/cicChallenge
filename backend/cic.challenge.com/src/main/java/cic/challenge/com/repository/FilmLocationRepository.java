package cic.challenge.com.repository;

import cic.challenge.com.entity.FilmLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmLocationRepository extends PagingAndSortingRepository<FilmLocation, Long> {

    @Query("select f from FilmLocation f where upper(f.location) like :location")
    Page<FilmLocation> searchByLocation(@Param("location") String location, Pageable pageable);

}
