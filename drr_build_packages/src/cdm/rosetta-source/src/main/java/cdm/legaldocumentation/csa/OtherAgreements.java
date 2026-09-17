package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.common.OtherAgreementTerms;
import cdm.legaldocumentation.csa.meta.OtherAgreementsMeta;
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
 * The bespoke definition of other agreement terms as specified by the parties to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="OtherAgreements", builder=OtherAgreements.OtherAgreementsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="OtherAgreements", model="cdm", builder=OtherAgreements.OtherAgreementsBuilderImpl.class, version="6.23.0")
public interface OtherAgreements extends RosettaModelObject {

	OtherAgreementsMeta metaData = new OtherAgreementsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The bespoke definition of Other CSA as specified by the parties to the agreement.
	 */
	OtherAgreementTerms getOtherCsa();
	/**
	 * The bespoke definition of whether Japanese Law CSA (VM) are specified by the parties to the agreement.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(s)(ii)" * name "Japanese Law CSA (VM)"
	 *
	 * Provision 
	 *
	 */
	OtherAgreementTerms getJapaneseLawCsa();

	/*********************** Build Methods  ***********************/
	OtherAgreements build();
	
	OtherAgreements.OtherAgreementsBuilder toBuilder();
	
	static OtherAgreements.OtherAgreementsBuilder builder() {
		return new OtherAgreements.OtherAgreementsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreements> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherAgreements> getType() {
		return OtherAgreements.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("otherCsa"), processor, OtherAgreementTerms.class, getOtherCsa());
		processRosetta(path.newSubPath("japaneseLawCsa"), processor, OtherAgreementTerms.class, getJapaneseLawCsa());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementsBuilder extends OtherAgreements, RosettaModelObjectBuilder {
		OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateOtherCsa();
		@Override
		OtherAgreementTerms.OtherAgreementTermsBuilder getOtherCsa();
		OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateJapaneseLawCsa();
		@Override
		OtherAgreementTerms.OtherAgreementTermsBuilder getJapaneseLawCsa();
		OtherAgreements.OtherAgreementsBuilder setOtherCsa(OtherAgreementTerms otherCsa);
		OtherAgreements.OtherAgreementsBuilder setJapaneseLawCsa(OtherAgreementTerms japaneseLawCsa);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("otherCsa"), processor, OtherAgreementTerms.OtherAgreementTermsBuilder.class, getOtherCsa());
			processRosetta(path.newSubPath("japaneseLawCsa"), processor, OtherAgreementTerms.OtherAgreementTermsBuilder.class, getJapaneseLawCsa());
		}
		

		OtherAgreements.OtherAgreementsBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreements  ***********************/
	class OtherAgreementsImpl implements OtherAgreements {
		private final OtherAgreementTerms otherCsa;
		private final OtherAgreementTerms japaneseLawCsa;
		
		protected OtherAgreementsImpl(OtherAgreements.OtherAgreementsBuilder builder) {
			this.otherCsa = ofNullable(builder.getOtherCsa()).map(f->f.build()).orElse(null);
			this.japaneseLawCsa = ofNullable(builder.getJapaneseLawCsa()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("otherCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCsa")
		public OtherAgreementTerms getOtherCsa() {
			return otherCsa;
		}
		
		@Override
		@RosettaAttribute("japaneseLawCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("japaneseLawCsa")
		public OtherAgreementTerms getJapaneseLawCsa() {
			return japaneseLawCsa;
		}
		
		@Override
		public OtherAgreements build() {
			return this;
		}
		
		@Override
		public OtherAgreements.OtherAgreementsBuilder toBuilder() {
			OtherAgreements.OtherAgreementsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreements.OtherAgreementsBuilder builder) {
			ofNullable(getOtherCsa()).ifPresent(builder::setOtherCsa);
			ofNullable(getJapaneseLawCsa()).ifPresent(builder::setJapaneseLawCsa);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreements _that = getType().cast(o);
		
			if (!Objects.equals(otherCsa, _that.getOtherCsa())) return false;
			if (!Objects.equals(japaneseLawCsa, _that.getJapaneseLawCsa())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherCsa != null ? otherCsa.hashCode() : 0);
			_result = 31 * _result + (japaneseLawCsa != null ? japaneseLawCsa.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreements {" +
				"otherCsa=" + this.otherCsa + ", " +
				"japaneseLawCsa=" + this.japaneseLawCsa +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreements  ***********************/
	class OtherAgreementsBuilderImpl implements OtherAgreements.OtherAgreementsBuilder {
	
		protected OtherAgreementTerms.OtherAgreementTermsBuilder otherCsa;
		protected OtherAgreementTerms.OtherAgreementTermsBuilder japaneseLawCsa;
		
		@Override
		@RosettaAttribute("otherCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCsa")
		public OtherAgreementTerms.OtherAgreementTermsBuilder getOtherCsa() {
			return otherCsa;
		}
		
		@Override
		public OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateOtherCsa() {
			OtherAgreementTerms.OtherAgreementTermsBuilder result;
			if (otherCsa!=null) {
				result = otherCsa;
			}
			else {
				result = otherCsa = OtherAgreementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("japaneseLawCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("japaneseLawCsa")
		public OtherAgreementTerms.OtherAgreementTermsBuilder getJapaneseLawCsa() {
			return japaneseLawCsa;
		}
		
		@Override
		public OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateJapaneseLawCsa() {
			OtherAgreementTerms.OtherAgreementTermsBuilder result;
			if (japaneseLawCsa!=null) {
				result = japaneseLawCsa;
			}
			else {
				result = japaneseLawCsa = OtherAgreementTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("otherCsa")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherCsa")
		@Override
		public OtherAgreements.OtherAgreementsBuilder setOtherCsa(OtherAgreementTerms _otherCsa) {
			this.otherCsa = _otherCsa == null ? null : _otherCsa.toBuilder();
			return this;
		}
		
		@RosettaAttribute("japaneseLawCsa")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("japaneseLawCsa")
		@Override
		public OtherAgreements.OtherAgreementsBuilder setJapaneseLawCsa(OtherAgreementTerms _japaneseLawCsa) {
			this.japaneseLawCsa = _japaneseLawCsa == null ? null : _japaneseLawCsa.toBuilder();
			return this;
		}
		
		@Override
		public OtherAgreements build() {
			return new OtherAgreements.OtherAgreementsImpl(this);
		}
		
		@Override
		public OtherAgreements.OtherAgreementsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreements.OtherAgreementsBuilder prune() {
			if (otherCsa!=null && !otherCsa.prune().hasData()) otherCsa = null;
			if (japaneseLawCsa!=null && !japaneseLawCsa.prune().hasData()) japaneseLawCsa = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOtherCsa()!=null && getOtherCsa().hasData()) return true;
			if (getJapaneseLawCsa()!=null && getJapaneseLawCsa().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreements.OtherAgreementsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreements.OtherAgreementsBuilder o = (OtherAgreements.OtherAgreementsBuilder) other;
			
			merger.mergeRosetta(getOtherCsa(), o.getOtherCsa(), this::setOtherCsa);
			merger.mergeRosetta(getJapaneseLawCsa(), o.getJapaneseLawCsa(), this::setJapaneseLawCsa);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreements _that = getType().cast(o);
		
			if (!Objects.equals(otherCsa, _that.getOtherCsa())) return false;
			if (!Objects.equals(japaneseLawCsa, _that.getJapaneseLawCsa())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherCsa != null ? otherCsa.hashCode() : 0);
			_result = 31 * _result + (japaneseLawCsa != null ? japaneseLawCsa.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementsBuilder {" +
				"otherCsa=" + this.otherCsa + ", " +
				"japaneseLawCsa=" + this.japaneseLawCsa +
			'}';
		}
	}
}
