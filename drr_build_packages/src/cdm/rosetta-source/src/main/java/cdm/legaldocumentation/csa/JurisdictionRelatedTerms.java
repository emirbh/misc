package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.JurisdictionRelatedTermsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify terms jurisdiction related terms.
 * @version 6.23.0
 */
@RosettaDataType(value="JurisdictionRelatedTerms", builder=JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="JurisdictionRelatedTerms", model="cdm", builder=JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilderImpl.class, version="6.23.0")
public interface JurisdictionRelatedTerms extends RosettaModelObject {

	JurisdictionRelatedTermsMeta metaData = new JurisdictionRelatedTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Japanese Securities Provisions election.
	 */
	JapaneseSecuritiesProvisions getJapaneseSecuritiesProvisions();
	/**
	 * Classification of optional exclusive jurisdiction terms.
	 */
	Boolean getExclusiveJurisdiction();
	/**
	 * The Jury Waiver conditions specific to the agreement.
	 */
	Boolean getJuryWaiver();
	/**
	 * The French Law Addendum Provisions specific to the agreement.
	 */
	FrenchLawAddendum getFrenchLawAddendum();
	/**
	 * The qualification of whether the Belgian Law Security Agreement Addendum is deemed applicable by the parties (True) or not (False).
	 */
	Boolean getBelgianLawSecurityAgreement();

	/*********************** Build Methods  ***********************/
	JurisdictionRelatedTerms build();
	
	JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder toBuilder();
	
	static JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder() {
		return new JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends JurisdictionRelatedTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends JurisdictionRelatedTerms> getType() {
		return JurisdictionRelatedTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("japaneseSecuritiesProvisions"), processor, JapaneseSecuritiesProvisions.class, getJapaneseSecuritiesProvisions());
		processor.processBasic(path.newSubPath("exclusiveJurisdiction"), Boolean.class, getExclusiveJurisdiction(), this);
		processor.processBasic(path.newSubPath("juryWaiver"), Boolean.class, getJuryWaiver(), this);
		processRosetta(path.newSubPath("frenchLawAddendum"), processor, FrenchLawAddendum.class, getFrenchLawAddendum());
		processor.processBasic(path.newSubPath("belgianLawSecurityAgreement"), Boolean.class, getBelgianLawSecurityAgreement(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface JurisdictionRelatedTermsBuilder extends JurisdictionRelatedTerms, RosettaModelObjectBuilder {
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getOrCreateJapaneseSecuritiesProvisions();
		@Override
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getJapaneseSecuritiesProvisions();
		FrenchLawAddendum.FrenchLawAddendumBuilder getOrCreateFrenchLawAddendum();
		@Override
		FrenchLawAddendum.FrenchLawAddendumBuilder getFrenchLawAddendum();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJapaneseSecuritiesProvisions(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions);
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setExclusiveJurisdiction(Boolean exclusiveJurisdiction);
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJuryWaiver(Boolean juryWaiver);
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setFrenchLawAddendum(FrenchLawAddendum frenchLawAddendum);
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setBelgianLawSecurityAgreement(Boolean belgianLawSecurityAgreement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("japaneseSecuritiesProvisions"), processor, JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder.class, getJapaneseSecuritiesProvisions());
			processor.processBasic(path.newSubPath("exclusiveJurisdiction"), Boolean.class, getExclusiveJurisdiction(), this);
			processor.processBasic(path.newSubPath("juryWaiver"), Boolean.class, getJuryWaiver(), this);
			processRosetta(path.newSubPath("frenchLawAddendum"), processor, FrenchLawAddendum.FrenchLawAddendumBuilder.class, getFrenchLawAddendum());
			processor.processBasic(path.newSubPath("belgianLawSecurityAgreement"), Boolean.class, getBelgianLawSecurityAgreement(), this);
		}
		

		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder prune();
	}

	/*********************** Immutable Implementation of JurisdictionRelatedTerms  ***********************/
	class JurisdictionRelatedTermsImpl implements JurisdictionRelatedTerms {
		private final JapaneseSecuritiesProvisions japaneseSecuritiesProvisions;
		private final Boolean exclusiveJurisdiction;
		private final Boolean juryWaiver;
		private final FrenchLawAddendum frenchLawAddendum;
		private final Boolean belgianLawSecurityAgreement;
		
		protected JurisdictionRelatedTermsImpl(JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder) {
			this.japaneseSecuritiesProvisions = ofNullable(builder.getJapaneseSecuritiesProvisions()).map(f->f.build()).orElse(null);
			this.exclusiveJurisdiction = builder.getExclusiveJurisdiction();
			this.juryWaiver = builder.getJuryWaiver();
			this.frenchLawAddendum = ofNullable(builder.getFrenchLawAddendum()).map(f->f.build()).orElse(null);
			this.belgianLawSecurityAgreement = builder.getBelgianLawSecurityAgreement();
		}
		
		@Override
		@RosettaAttribute("japaneseSecuritiesProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("japaneseSecuritiesProvisions")
		public JapaneseSecuritiesProvisions getJapaneseSecuritiesProvisions() {
			return japaneseSecuritiesProvisions;
		}
		
		@Override
		@RosettaAttribute("exclusiveJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exclusiveJurisdiction")
		public Boolean getExclusiveJurisdiction() {
			return exclusiveJurisdiction;
		}
		
		@Override
		@RosettaAttribute("juryWaiver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("juryWaiver")
		public Boolean getJuryWaiver() {
			return juryWaiver;
		}
		
		@Override
		@RosettaAttribute("frenchLawAddendum")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frenchLawAddendum")
		public FrenchLawAddendum getFrenchLawAddendum() {
			return frenchLawAddendum;
		}
		
		@Override
		@RosettaAttribute("belgianLawSecurityAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("belgianLawSecurityAgreement")
		public Boolean getBelgianLawSecurityAgreement() {
			return belgianLawSecurityAgreement;
		}
		
		@Override
		public JurisdictionRelatedTerms build() {
			return this;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder toBuilder() {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder) {
			ofNullable(getJapaneseSecuritiesProvisions()).ifPresent(builder::setJapaneseSecuritiesProvisions);
			ofNullable(getExclusiveJurisdiction()).ifPresent(builder::setExclusiveJurisdiction);
			ofNullable(getJuryWaiver()).ifPresent(builder::setJuryWaiver);
			ofNullable(getFrenchLawAddendum()).ifPresent(builder::setFrenchLawAddendum);
			ofNullable(getBelgianLawSecurityAgreement()).ifPresent(builder::setBelgianLawSecurityAgreement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JurisdictionRelatedTerms _that = getType().cast(o);
		
			if (!Objects.equals(japaneseSecuritiesProvisions, _that.getJapaneseSecuritiesProvisions())) return false;
			if (!Objects.equals(exclusiveJurisdiction, _that.getExclusiveJurisdiction())) return false;
			if (!Objects.equals(juryWaiver, _that.getJuryWaiver())) return false;
			if (!Objects.equals(frenchLawAddendum, _that.getFrenchLawAddendum())) return false;
			if (!Objects.equals(belgianLawSecurityAgreement, _that.getBelgianLawSecurityAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (japaneseSecuritiesProvisions != null ? japaneseSecuritiesProvisions.hashCode() : 0);
			_result = 31 * _result + (exclusiveJurisdiction != null ? exclusiveJurisdiction.hashCode() : 0);
			_result = 31 * _result + (juryWaiver != null ? juryWaiver.hashCode() : 0);
			_result = 31 * _result + (frenchLawAddendum != null ? frenchLawAddendum.hashCode() : 0);
			_result = 31 * _result + (belgianLawSecurityAgreement != null ? belgianLawSecurityAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JurisdictionRelatedTerms {" +
				"japaneseSecuritiesProvisions=" + this.japaneseSecuritiesProvisions + ", " +
				"exclusiveJurisdiction=" + this.exclusiveJurisdiction + ", " +
				"juryWaiver=" + this.juryWaiver + ", " +
				"frenchLawAddendum=" + this.frenchLawAddendum + ", " +
				"belgianLawSecurityAgreement=" + this.belgianLawSecurityAgreement +
			'}';
		}
	}

	/*********************** Builder Implementation of JurisdictionRelatedTerms  ***********************/
	class JurisdictionRelatedTermsBuilderImpl implements JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder {
	
		protected JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder japaneseSecuritiesProvisions;
		protected Boolean exclusiveJurisdiction;
		protected Boolean juryWaiver;
		protected FrenchLawAddendum.FrenchLawAddendumBuilder frenchLawAddendum;
		protected Boolean belgianLawSecurityAgreement;
		
		@Override
		@RosettaAttribute("japaneseSecuritiesProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("japaneseSecuritiesProvisions")
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getJapaneseSecuritiesProvisions() {
			return japaneseSecuritiesProvisions;
		}
		
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getOrCreateJapaneseSecuritiesProvisions() {
			JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder result;
			if (japaneseSecuritiesProvisions!=null) {
				result = japaneseSecuritiesProvisions;
			}
			else {
				result = japaneseSecuritiesProvisions = JapaneseSecuritiesProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exclusiveJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exclusiveJurisdiction")
		public Boolean getExclusiveJurisdiction() {
			return exclusiveJurisdiction;
		}
		
		@Override
		@RosettaAttribute("juryWaiver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("juryWaiver")
		public Boolean getJuryWaiver() {
			return juryWaiver;
		}
		
		@Override
		@RosettaAttribute("frenchLawAddendum")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frenchLawAddendum")
		public FrenchLawAddendum.FrenchLawAddendumBuilder getFrenchLawAddendum() {
			return frenchLawAddendum;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder getOrCreateFrenchLawAddendum() {
			FrenchLawAddendum.FrenchLawAddendumBuilder result;
			if (frenchLawAddendum!=null) {
				result = frenchLawAddendum;
			}
			else {
				result = frenchLawAddendum = FrenchLawAddendum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("belgianLawSecurityAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("belgianLawSecurityAgreement")
		public Boolean getBelgianLawSecurityAgreement() {
			return belgianLawSecurityAgreement;
		}
		
		@RosettaAttribute("japaneseSecuritiesProvisions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("japaneseSecuritiesProvisions")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJapaneseSecuritiesProvisions(JapaneseSecuritiesProvisions _japaneseSecuritiesProvisions) {
			this.japaneseSecuritiesProvisions = _japaneseSecuritiesProvisions == null ? null : _japaneseSecuritiesProvisions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exclusiveJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exclusiveJurisdiction")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setExclusiveJurisdiction(Boolean _exclusiveJurisdiction) {
			this.exclusiveJurisdiction = _exclusiveJurisdiction == null ? null : _exclusiveJurisdiction;
			return this;
		}
		
		@RosettaAttribute("juryWaiver")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("juryWaiver")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJuryWaiver(Boolean _juryWaiver) {
			this.juryWaiver = _juryWaiver == null ? null : _juryWaiver;
			return this;
		}
		
		@RosettaAttribute("frenchLawAddendum")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frenchLawAddendum")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setFrenchLawAddendum(FrenchLawAddendum _frenchLawAddendum) {
			this.frenchLawAddendum = _frenchLawAddendum == null ? null : _frenchLawAddendum.toBuilder();
			return this;
		}
		
		@RosettaAttribute("belgianLawSecurityAgreement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("belgianLawSecurityAgreement")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setBelgianLawSecurityAgreement(Boolean _belgianLawSecurityAgreement) {
			this.belgianLawSecurityAgreement = _belgianLawSecurityAgreement == null ? null : _belgianLawSecurityAgreement;
			return this;
		}
		
		@Override
		public JurisdictionRelatedTerms build() {
			return new JurisdictionRelatedTerms.JurisdictionRelatedTermsImpl(this);
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder prune() {
			if (japaneseSecuritiesProvisions!=null && !japaneseSecuritiesProvisions.prune().hasData()) japaneseSecuritiesProvisions = null;
			if (frenchLawAddendum!=null && !frenchLawAddendum.prune().hasData()) frenchLawAddendum = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getJapaneseSecuritiesProvisions()!=null && getJapaneseSecuritiesProvisions().hasData()) return true;
			if (getExclusiveJurisdiction()!=null) return true;
			if (getJuryWaiver()!=null) return true;
			if (getFrenchLawAddendum()!=null && getFrenchLawAddendum().hasData()) return true;
			if (getBelgianLawSecurityAgreement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder o = (JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder) other;
			
			merger.mergeRosetta(getJapaneseSecuritiesProvisions(), o.getJapaneseSecuritiesProvisions(), this::setJapaneseSecuritiesProvisions);
			merger.mergeRosetta(getFrenchLawAddendum(), o.getFrenchLawAddendum(), this::setFrenchLawAddendum);
			
			merger.mergeBasic(getExclusiveJurisdiction(), o.getExclusiveJurisdiction(), this::setExclusiveJurisdiction);
			merger.mergeBasic(getJuryWaiver(), o.getJuryWaiver(), this::setJuryWaiver);
			merger.mergeBasic(getBelgianLawSecurityAgreement(), o.getBelgianLawSecurityAgreement(), this::setBelgianLawSecurityAgreement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JurisdictionRelatedTerms _that = getType().cast(o);
		
			if (!Objects.equals(japaneseSecuritiesProvisions, _that.getJapaneseSecuritiesProvisions())) return false;
			if (!Objects.equals(exclusiveJurisdiction, _that.getExclusiveJurisdiction())) return false;
			if (!Objects.equals(juryWaiver, _that.getJuryWaiver())) return false;
			if (!Objects.equals(frenchLawAddendum, _that.getFrenchLawAddendum())) return false;
			if (!Objects.equals(belgianLawSecurityAgreement, _that.getBelgianLawSecurityAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (japaneseSecuritiesProvisions != null ? japaneseSecuritiesProvisions.hashCode() : 0);
			_result = 31 * _result + (exclusiveJurisdiction != null ? exclusiveJurisdiction.hashCode() : 0);
			_result = 31 * _result + (juryWaiver != null ? juryWaiver.hashCode() : 0);
			_result = 31 * _result + (frenchLawAddendum != null ? frenchLawAddendum.hashCode() : 0);
			_result = 31 * _result + (belgianLawSecurityAgreement != null ? belgianLawSecurityAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JurisdictionRelatedTermsBuilder {" +
				"japaneseSecuritiesProvisions=" + this.japaneseSecuritiesProvisions + ", " +
				"exclusiveJurisdiction=" + this.exclusiveJurisdiction + ", " +
				"juryWaiver=" + this.juryWaiver + ", " +
				"frenchLawAddendum=" + this.frenchLawAddendum + ", " +
				"belgianLawSecurityAgreement=" + this.belgianLawSecurityAgreement +
			'}';
		}
	}
}
