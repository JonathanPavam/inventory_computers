import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ComputerDTO } from '../model/computer.model';

@Injectable({
  providedIn: 'root'
})
export class ComputerService {
  private http = inject(HttpClient);
  // Confirme se no seu @RequestMapping do Spring está "/computers" ou "/computer"
  private apiUrl = 'http://localhost:4000/api/computer/v1';

  findById(id: number): Observable<ComputerDTO> {
    return this.http.get<ComputerDTO>(`${this.apiUrl}/${id}`);
  }

  create(computer: ComputerDTO): Observable<ComputerDTO> {
    return this.http.post<ComputerDTO>(this.apiUrl, computer);
  }

  update(id: number, computer: ComputerDTO): Observable<ComputerDTO> {
    return this.http.put<ComputerDTO>(`${this.apiUrl}/${id}`, computer);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}