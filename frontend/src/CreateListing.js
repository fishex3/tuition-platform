import React, { useState } from 'react';

function CreateListing() {
  // These track what the user types into the boxes
  const [subject, setSubject] = useState('');
  const [level, setLevel] = useState('');
  const [rate, setRate] = useState('');

  // This function runs when they click the Submit button
  const handleSubmit = async (e) => {
    e.preventDefault();

    const listingData = {
      subject: subject,
      level: level,
      hourlyRate: rate
    };

    try {
      // This sends the data directly to the Java API you just built!
      const response = await fetch('http://localhost:8080/api/posts/tutor', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(listingData),
      });

      if (response.ok) {
        alert('Success! Your backend received the listing.');
      } else {
        alert('Failed to connect to the backend.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('Error connecting to the server. Is your Java backend running?');
    }
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', margin: 'auto', fontFamily: 'sans-serif' }}>
      <h2>Create Tutor Listing</h2>
      
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
        
        <label>Subject (e.g., Math, Physics):</label>
        <input 
          type="text" 
          value={subject} 
          onChange={(e) => setSubject(e.target.value)} 
          required 
          style={{ padding: '8px' }}
        />

        <label>Level (e.g., Primary, JC):</label>
        <input 
          type="text" 
          value={level} 
          onChange={(e) => setLevel(e.target.value)} 
          required 
          style={{ padding: '8px' }}
        />

        <label>Hourly Rate ($):</label>
        <input 
          type="number" 
          value={rate} 
          onChange={(e) => setRate(e.target.value)} 
          required 
          style={{ padding: '8px' }}
        />

        <button type="submit" style={{ padding: '10px', backgroundColor: '#007BFF', color: 'white', border: 'none', cursor: 'pointer' }}>
          Post Listing
        </button>
        
      </form>
    </div>
  );
}

export default CreateListing;