import React, { useState, useEffect } from 'react';

function ViewTuteeListings() {
  const [listings, setListings] = useState([]);

  useEffect(() => {
    // Notice this fetches from /tutee!
    fetch('http://localhost:8080/api/posts/tutee')
      .then(response => response.json())
      .then(data => setListings(data))
      .catch(error => console.error('Error fetching listings:', error));
  }, []);

  return (
    <div style={{ padding: '20px', maxWidth: '600px', margin: 'auto', fontFamily: 'sans-serif' }}>
      <h2>Students Looking For Help</h2>
      {listings.length === 0 ? (
        <p>No student requests right now.</p>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
          {listings.map((tutee, index) => (
            <div key={index} style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', backgroundColor: '#fff9e6' }}>
              <h3 style={{ margin: '0 0 10px 0', color: '#d39e00' }}>Needs help with: {tutee.subject}</h3>
              <p style={{ margin: '5px 0' }}><strong>Level:</strong> {tutee.educationLevel}</p>
              <p style={{ margin: '5px 0' }}><strong>Budget:</strong> ${tutee.rates}/hr</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default ViewTuteeListings;


