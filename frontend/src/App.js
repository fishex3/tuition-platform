import React from 'react';
import CreateListing from './CreateListing';
import ViewListings from './ViewListings';
import CreateTuteeListing from './CreateTuteeListing';
import ViewTuteeListings from './ViewTuteeListings';

function App() {
  return (
    <div style={{ fontFamily: 'sans-serif' }}>
      <h1 style={{ textAlign: 'center', margin: '20px 0' }}>Tuition Matching Platform</h1>
      
      {/* Top Half: Tutors */}
      <div style={{ display: 'flex', justifyContent: 'space-around', padding: '20px', borderBottom: '3px solid #ccc' }}>
        <div style={{ flex: 1 }}><CreateListing /></div>
        <div style={{ flex: 1 }}><ViewListings /></div>
      </div>

      {/* Bottom Half: Tutees */}
      <div style={{ display: 'flex', justifyContent: 'space-around', padding: '20px' }}>
        <div style={{ flex: 1 }}><CreateTuteeListing /></div>
        <div style={{ flex: 1 }}><ViewTuteeListings /></div>
      </div>
    </div>
  );
}

export default App;


