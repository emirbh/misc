package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.RegimeTermsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
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
 * A class that is used by the ApplicableRegime and the AdditionalRegime classes to specify the regulatory regime terms.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * name "Regime"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2018 ISDA 2018 Credit Support Annex For Initial Margin  
 * name "Regime"
 *
 * Provision 
 *
 */
@RosettaDataType(value="RegimeTerms", builder=RegimeTerms.RegimeTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="RegimeTerms", model="cdm", builder=RegimeTerms.RegimeTermsBuilderImpl.class, version="6.23.0")
public interface RegimeTerms extends RosettaModelObject {

	RegimeTermsMeta metaData = new RegimeTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party for which the regime terms are being specified when acting as collateral taker.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The specification of whether the regime is elected as applicable to the party when acting as collateral taker.
	 */
	ExceptionEnum getIsApplicable();
	/**
	 * The bespoke party specific Regime term elections applicable when specified.
	 */
	String getAsSpecified();
	/**
	 * The election for SIMM exception to the regulatory regime clause.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13"
	 *
	 * Provision 
	 *
	 */
	SimmException getSimmException();
	/**
	 * Specifies the retrospective effect exception to the regulatory regime clause of Initial Margin documents as either a normalized value specified as part of an enumeration or a customized value specified of type string.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13" * clause "(b)(i)"
	 *
	 * Provision 
	 *
	 */
	RetrospectiveEffect getRetrospectiveEffect();

	/*********************** Build Methods  ***********************/
	RegimeTerms build();
	
	RegimeTerms.RegimeTermsBuilder toBuilder();
	
	static RegimeTerms.RegimeTermsBuilder builder() {
		return new RegimeTerms.RegimeTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegimeTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegimeTerms> getType() {
		return RegimeTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isApplicable"), ExceptionEnum.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		processRosetta(path.newSubPath("simmException"), processor, SimmException.class, getSimmException());
		processRosetta(path.newSubPath("retrospectiveEffect"), processor, RetrospectiveEffect.class, getRetrospectiveEffect());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegimeTermsBuilder extends RegimeTerms, RosettaModelObjectBuilder {
		SimmException.SimmExceptionBuilder getOrCreateSimmException();
		@Override
		SimmException.SimmExceptionBuilder getSimmException();
		RetrospectiveEffect.RetrospectiveEffectBuilder getOrCreateRetrospectiveEffect();
		@Override
		RetrospectiveEffect.RetrospectiveEffectBuilder getRetrospectiveEffect();
		RegimeTerms.RegimeTermsBuilder setParty(CounterpartyRoleEnum party);
		RegimeTerms.RegimeTermsBuilder setIsApplicable(ExceptionEnum isApplicable);
		RegimeTerms.RegimeTermsBuilder setAsSpecified(String asSpecified);
		RegimeTerms.RegimeTermsBuilder setSimmException(SimmException simmException);
		RegimeTerms.RegimeTermsBuilder setRetrospectiveEffect(RetrospectiveEffect retrospectiveEffect);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isApplicable"), ExceptionEnum.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
			processRosetta(path.newSubPath("simmException"), processor, SimmException.SimmExceptionBuilder.class, getSimmException());
			processRosetta(path.newSubPath("retrospectiveEffect"), processor, RetrospectiveEffect.RetrospectiveEffectBuilder.class, getRetrospectiveEffect());
		}
		

		RegimeTerms.RegimeTermsBuilder prune();
	}

	/*********************** Immutable Implementation of RegimeTerms  ***********************/
	class RegimeTermsImpl implements RegimeTerms {
		private final CounterpartyRoleEnum party;
		private final ExceptionEnum isApplicable;
		private final String asSpecified;
		private final SimmException simmException;
		private final RetrospectiveEffect retrospectiveEffect;
		
		protected RegimeTermsImpl(RegimeTerms.RegimeTermsBuilder builder) {
			this.party = builder.getParty();
			this.isApplicable = builder.getIsApplicable();
			this.asSpecified = builder.getAsSpecified();
			this.simmException = ofNullable(builder.getSimmException()).map(f->f.build()).orElse(null);
			this.retrospectiveEffect = ofNullable(builder.getRetrospectiveEffect()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isApplicable")
		public ExceptionEnum getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asSpecified")
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		@RosettaAttribute("simmException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("simmException")
		public SimmException getSimmException() {
			return simmException;
		}
		
		@Override
		@RosettaAttribute("retrospectiveEffect")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("retrospectiveEffect")
		public RetrospectiveEffect getRetrospectiveEffect() {
			return retrospectiveEffect;
		}
		
		@Override
		public RegimeTerms build() {
			return this;
		}
		
		@Override
		public RegimeTerms.RegimeTermsBuilder toBuilder() {
			RegimeTerms.RegimeTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegimeTerms.RegimeTermsBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
			ofNullable(getSimmException()).ifPresent(builder::setSimmException);
			ofNullable(getRetrospectiveEffect()).ifPresent(builder::setRetrospectiveEffect);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegimeTerms _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(simmException, _that.getSimmException())) return false;
			if (!Objects.equals(retrospectiveEffect, _that.getRetrospectiveEffect())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (simmException != null ? simmException.hashCode() : 0);
			_result = 31 * _result + (retrospectiveEffect != null ? retrospectiveEffect.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeTerms {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"asSpecified=" + this.asSpecified + ", " +
				"simmException=" + this.simmException + ", " +
				"retrospectiveEffect=" + this.retrospectiveEffect +
			'}';
		}
	}

	/*********************** Builder Implementation of RegimeTerms  ***********************/
	class RegimeTermsBuilderImpl implements RegimeTerms.RegimeTermsBuilder {
	
		protected CounterpartyRoleEnum party;
		protected ExceptionEnum isApplicable;
		protected String asSpecified;
		protected SimmException.SimmExceptionBuilder simmException;
		protected RetrospectiveEffect.RetrospectiveEffectBuilder retrospectiveEffect;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isApplicable")
		public ExceptionEnum getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asSpecified")
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		@RosettaAttribute("simmException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("simmException")
		public SimmException.SimmExceptionBuilder getSimmException() {
			return simmException;
		}
		
		@Override
		public SimmException.SimmExceptionBuilder getOrCreateSimmException() {
			SimmException.SimmExceptionBuilder result;
			if (simmException!=null) {
				result = simmException;
			}
			else {
				result = simmException = SimmException.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("retrospectiveEffect")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("retrospectiveEffect")
		public RetrospectiveEffect.RetrospectiveEffectBuilder getRetrospectiveEffect() {
			return retrospectiveEffect;
		}
		
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder getOrCreateRetrospectiveEffect() {
			RetrospectiveEffect.RetrospectiveEffectBuilder result;
			if (retrospectiveEffect!=null) {
				result = retrospectiveEffect;
			}
			else {
				result = retrospectiveEffect = RetrospectiveEffect.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public RegimeTerms.RegimeTermsBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isApplicable")
		@Override
		public RegimeTerms.RegimeTermsBuilder setIsApplicable(ExceptionEnum _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asSpecified")
		@Override
		public RegimeTerms.RegimeTermsBuilder setAsSpecified(String _asSpecified) {
			this.asSpecified = _asSpecified == null ? null : _asSpecified;
			return this;
		}
		
		@RosettaAttribute("simmException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("simmException")
		@Override
		public RegimeTerms.RegimeTermsBuilder setSimmException(SimmException _simmException) {
			this.simmException = _simmException == null ? null : _simmException.toBuilder();
			return this;
		}
		
		@RosettaAttribute("retrospectiveEffect")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("retrospectiveEffect")
		@Override
		public RegimeTerms.RegimeTermsBuilder setRetrospectiveEffect(RetrospectiveEffect _retrospectiveEffect) {
			this.retrospectiveEffect = _retrospectiveEffect == null ? null : _retrospectiveEffect.toBuilder();
			return this;
		}
		
		@Override
		public RegimeTerms build() {
			return new RegimeTerms.RegimeTermsImpl(this);
		}
		
		@Override
		public RegimeTerms.RegimeTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeTerms.RegimeTermsBuilder prune() {
			if (simmException!=null && !simmException.prune().hasData()) simmException = null;
			if (retrospectiveEffect!=null && !retrospectiveEffect.prune().hasData()) retrospectiveEffect = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getIsApplicable()!=null) return true;
			if (getAsSpecified()!=null) return true;
			if (getSimmException()!=null && getSimmException().hasData()) return true;
			if (getRetrospectiveEffect()!=null && getRetrospectiveEffect().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeTerms.RegimeTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegimeTerms.RegimeTermsBuilder o = (RegimeTerms.RegimeTermsBuilder) other;
			
			merger.mergeRosetta(getSimmException(), o.getSimmException(), this::setSimmException);
			merger.mergeRosetta(getRetrospectiveEffect(), o.getRetrospectiveEffect(), this::setRetrospectiveEffect);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegimeTerms _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			if (!Objects.equals(simmException, _that.getSimmException())) return false;
			if (!Objects.equals(retrospectiveEffect, _that.getRetrospectiveEffect())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			_result = 31 * _result + (simmException != null ? simmException.hashCode() : 0);
			_result = 31 * _result + (retrospectiveEffect != null ? retrospectiveEffect.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeTermsBuilder {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"asSpecified=" + this.asSpecified + ", " +
				"simmException=" + this.simmException + ", " +
				"retrospectiveEffect=" + this.retrospectiveEffect +
			'}';
		}
	}
}
