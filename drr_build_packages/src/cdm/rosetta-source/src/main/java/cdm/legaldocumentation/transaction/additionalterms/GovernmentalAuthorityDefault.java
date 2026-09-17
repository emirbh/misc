package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.GovernmentalAuthorityDefaultMeta;
import cdm.observable.asset.ValuationPostponement;
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
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.1.(d).(v)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="GovernmentalAuthorityDefault", builder=GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilderImpl.class, version="6.23.0")
@RuneDataType(value="GovernmentalAuthorityDefault", model="cdm", builder=GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilderImpl.class, version="6.23.0")
public interface GovernmentalAuthorityDefault extends RosettaModelObject {

	GovernmentalAuthorityDefaultMeta metaData = new GovernmentalAuthorityDefaultMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getGovernmentalAuthorityDefaultIsApplicable();
	EscrowArrangement getEscrowArrangement();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.2.(c)" * paragraph "(vi)" * paragraph "(vii)" * paragraph "(viii)"
	 *
	 * Provision 
	 *
	 */
	FxSubstitutionProvisionTypeEnum getLocalSubstituteProvisionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.4.(w)"
	 *
	 * Provision 
	 *
	 */
	SpecifiedValueEnum getSpecifiedValue();
	ValuationPostponement getMaximumDaysOfDisruption();

	/*********************** Build Methods  ***********************/
	GovernmentalAuthorityDefault build();
	
	GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder toBuilder();
	
	static GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder builder() {
		return new GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GovernmentalAuthorityDefault> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GovernmentalAuthorityDefault> getType() {
		return GovernmentalAuthorityDefault.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("governmentalAuthorityDefaultIsApplicable"), Boolean.class, getGovernmentalAuthorityDefaultIsApplicable(), this);
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
		processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
		processor.processBasic(path.newSubPath("specifiedValue"), SpecifiedValueEnum.class, getSpecifiedValue(), this);
		processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.class, getMaximumDaysOfDisruption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GovernmentalAuthorityDefaultBuilder extends GovernmentalAuthorityDefault, RosettaModelObjectBuilder {
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption();
		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setGovernmentalAuthorityDefaultIsApplicable(Boolean governmentalAuthorityDefaultIsApplicable);
		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);
		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum localSubstituteProvisionType);
		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setSpecifiedValue(SpecifiedValueEnum specifiedValue);
		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setMaximumDaysOfDisruption(ValuationPostponement maximumDaysOfDisruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("governmentalAuthorityDefaultIsApplicable"), Boolean.class, getGovernmentalAuthorityDefaultIsApplicable(), this);
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
			processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
			processor.processBasic(path.newSubPath("specifiedValue"), SpecifiedValueEnum.class, getSpecifiedValue(), this);
			processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getMaximumDaysOfDisruption());
		}
		

		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder prune();
	}

	/*********************** Immutable Implementation of GovernmentalAuthorityDefault  ***********************/
	class GovernmentalAuthorityDefaultImpl implements GovernmentalAuthorityDefault {
		private final Boolean governmentalAuthorityDefaultIsApplicable;
		private final EscrowArrangement escrowArrangement;
		private final FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		private final SpecifiedValueEnum specifiedValue;
		private final ValuationPostponement maximumDaysOfDisruption;
		
		protected GovernmentalAuthorityDefaultImpl(GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder builder) {
			this.governmentalAuthorityDefaultIsApplicable = builder.getGovernmentalAuthorityDefaultIsApplicable();
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
			this.localSubstituteProvisionType = builder.getLocalSubstituteProvisionType();
			this.specifiedValue = builder.getSpecifiedValue();
			this.maximumDaysOfDisruption = ofNullable(builder.getMaximumDaysOfDisruption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("governmentalAuthorityDefaultIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("governmentalAuthorityDefaultIsApplicable")
		public Boolean getGovernmentalAuthorityDefaultIsApplicable() {
			return governmentalAuthorityDefaultIsApplicable;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localSubstituteProvisionType")
		public FxSubstitutionProvisionTypeEnum getLocalSubstituteProvisionType() {
			return localSubstituteProvisionType;
		}
		
		@Override
		@RosettaAttribute("specifiedValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specifiedValue")
		public SpecifiedValueEnum getSpecifiedValue() {
			return specifiedValue;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		public GovernmentalAuthorityDefault build() {
			return this;
		}
		
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder toBuilder() {
			GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder builder) {
			ofNullable(getGovernmentalAuthorityDefaultIsApplicable()).ifPresent(builder::setGovernmentalAuthorityDefaultIsApplicable);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
			ofNullable(getLocalSubstituteProvisionType()).ifPresent(builder::setLocalSubstituteProvisionType);
			ofNullable(getSpecifiedValue()).ifPresent(builder::setSpecifiedValue);
			ofNullable(getMaximumDaysOfDisruption()).ifPresent(builder::setMaximumDaysOfDisruption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GovernmentalAuthorityDefault _that = getType().cast(o);
		
			if (!Objects.equals(governmentalAuthorityDefaultIsApplicable, _that.getGovernmentalAuthorityDefaultIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(specifiedValue, _that.getSpecifiedValue())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (governmentalAuthorityDefaultIsApplicable != null ? governmentalAuthorityDefaultIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedValue != null ? specifiedValue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GovernmentalAuthorityDefault {" +
				"governmentalAuthorityDefaultIsApplicable=" + this.governmentalAuthorityDefaultIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"specifiedValue=" + this.specifiedValue + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption +
			'}';
		}
	}

	/*********************** Builder Implementation of GovernmentalAuthorityDefault  ***********************/
	class GovernmentalAuthorityDefaultBuilderImpl implements GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder {
	
		protected Boolean governmentalAuthorityDefaultIsApplicable;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		protected FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		protected SpecifiedValueEnum specifiedValue;
		protected ValuationPostponement.ValuationPostponementBuilder maximumDaysOfDisruption;
		
		@Override
		@RosettaAttribute("governmentalAuthorityDefaultIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("governmentalAuthorityDefaultIsApplicable")
		public Boolean getGovernmentalAuthorityDefaultIsApplicable() {
			return governmentalAuthorityDefaultIsApplicable;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		public EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement() {
			EscrowArrangement.EscrowArrangementBuilder result;
			if (escrowArrangement!=null) {
				result = escrowArrangement;
			}
			else {
				result = escrowArrangement = EscrowArrangement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localSubstituteProvisionType")
		public FxSubstitutionProvisionTypeEnum getLocalSubstituteProvisionType() {
			return localSubstituteProvisionType;
		}
		
		@Override
		@RosettaAttribute("specifiedValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specifiedValue")
		public SpecifiedValueEnum getSpecifiedValue() {
			return specifiedValue;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption() {
			ValuationPostponement.ValuationPostponementBuilder result;
			if (maximumDaysOfDisruption!=null) {
				result = maximumDaysOfDisruption;
			}
			else {
				result = maximumDaysOfDisruption = ValuationPostponement.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("governmentalAuthorityDefaultIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("governmentalAuthorityDefaultIsApplicable")
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setGovernmentalAuthorityDefaultIsApplicable(Boolean _governmentalAuthorityDefaultIsApplicable) {
			this.governmentalAuthorityDefaultIsApplicable = _governmentalAuthorityDefaultIsApplicable == null ? null : _governmentalAuthorityDefaultIsApplicable;
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localSubstituteProvisionType")
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum _localSubstituteProvisionType) {
			this.localSubstituteProvisionType = _localSubstituteProvisionType == null ? null : _localSubstituteProvisionType;
			return this;
		}
		
		@RosettaAttribute("specifiedValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specifiedValue")
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setSpecifiedValue(SpecifiedValueEnum _specifiedValue) {
			this.specifiedValue = _specifiedValue == null ? null : _specifiedValue;
			return this;
		}
		
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder setMaximumDaysOfDisruption(ValuationPostponement _maximumDaysOfDisruption) {
			this.maximumDaysOfDisruption = _maximumDaysOfDisruption == null ? null : _maximumDaysOfDisruption.toBuilder();
			return this;
		}
		
		@Override
		public GovernmentalAuthorityDefault build() {
			return new GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultImpl(this);
		}
		
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder prune() {
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			if (maximumDaysOfDisruption!=null && !maximumDaysOfDisruption.prune().hasData()) maximumDaysOfDisruption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGovernmentalAuthorityDefaultIsApplicable()!=null) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			if (getLocalSubstituteProvisionType()!=null) return true;
			if (getSpecifiedValue()!=null) return true;
			if (getMaximumDaysOfDisruption()!=null && getMaximumDaysOfDisruption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder o = (GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder) other;
			
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			merger.mergeRosetta(getMaximumDaysOfDisruption(), o.getMaximumDaysOfDisruption(), this::setMaximumDaysOfDisruption);
			
			merger.mergeBasic(getGovernmentalAuthorityDefaultIsApplicable(), o.getGovernmentalAuthorityDefaultIsApplicable(), this::setGovernmentalAuthorityDefaultIsApplicable);
			merger.mergeBasic(getLocalSubstituteProvisionType(), o.getLocalSubstituteProvisionType(), this::setLocalSubstituteProvisionType);
			merger.mergeBasic(getSpecifiedValue(), o.getSpecifiedValue(), this::setSpecifiedValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GovernmentalAuthorityDefault _that = getType().cast(o);
		
			if (!Objects.equals(governmentalAuthorityDefaultIsApplicable, _that.getGovernmentalAuthorityDefaultIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(specifiedValue, _that.getSpecifiedValue())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (governmentalAuthorityDefaultIsApplicable != null ? governmentalAuthorityDefaultIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedValue != null ? specifiedValue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GovernmentalAuthorityDefaultBuilder {" +
				"governmentalAuthorityDefaultIsApplicable=" + this.governmentalAuthorityDefaultIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"specifiedValue=" + this.specifiedValue + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption +
			'}';
		}
	}
}
