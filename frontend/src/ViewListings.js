import React, { useState, useEffect } from 'react';

function ViewListings() {
  const [listings, setListings] = useState([]);

  // This automatically fetches the data from your Java GET endpoint when the page loads
  useEffect(() => {
    fetch('http://localhost:8080/api/posts/tutor')
      .then(response => response.json())
      .then(data => setListings(data))
      .catch(error => console.error('Error fetching listings:', error));
  }, []);

  return (
    <div style={{ padding: '20px', maxWidth: '600px', margin: 'auto', fontFamily: 'sans-serif' }}>
      <h2>Available Tutors</h2>
      
      {listings.length === 0 ? (
        <p>No tutors available right now.</p>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
          {listings.map((tutor, index) => (
            <div key={index} style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', backgroundColor: '#f9f9f9' }}>
              <h3 style={{ margin: '0 0 10px 0', color: '#007BFF' }}>Subject: {tutor.subject}</h3>
              <p style={{ margin: '5px 0' }}><strong>Level:</strong> {tutor.educationLevel}</p>
              <p style={{ margin: '5px 0' }}><strong>Hourly Rate:</strong> ${tutor.rates}/hr</p>
              <p style={{ margin: '5px 0', fontSize: '14px', color: '#555' }}><strong>Description:</strong> {tutor.content}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default ViewListings;

