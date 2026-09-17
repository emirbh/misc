package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.FxBenchmarkObligationDefaultMeta;
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
 * section "5.1.(d).(i)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxBenchmarkObligationDefault", builder=FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FxBenchmarkObligationDefault", model="cdm", builder=FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilderImpl.class, version="6.23.0")
public interface FxBenchmarkObligationDefault extends RosettaModelObject {

	FxBenchmarkObligationDefaultMeta metaData = new FxBenchmarkObligationDefaultMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getBenchmarkObligationDefaultIsApplicable();
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
	EscrowArrangement getEscrowArrangement();

	/*********************** Build Methods  ***********************/
	FxBenchmarkObligationDefault build();
	
	FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder toBuilder();
	
	static FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder builder() {
		return new FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxBenchmarkObligationDefault> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxBenchmarkObligationDefault> getType() {
		return FxBenchmarkObligationDefault.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("benchmarkObligationDefaultIsApplicable"), Boolean.class, getBenchmarkObligationDefaultIsApplicable(), this);
		processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
		processor.processBasic(path.newSubPath("specifiedValue"), SpecifiedValueEnum.class, getSpecifiedValue(), this);
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxBenchmarkObligationDefaultBuilder extends FxBenchmarkObligationDefault, RosettaModelObjectBuilder {
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setBenchmarkObligationDefaultIsApplicable(Boolean benchmarkObligationDefaultIsApplicable);
		FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum localSubstituteProvisionType);
		FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setSpecifiedValue(SpecifiedValueEnum specifiedValue);
		FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("benchmarkObligationDefaultIsApplicable"), Boolean.class, getBenchmarkObligationDefaultIsApplicable(), this);
			processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
			processor.processBasic(path.newSubPath("specifiedValue"), SpecifiedValueEnum.class, getSpecifiedValue(), this);
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
		}
		

		FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder prune();
	}

	/*********************** Immutable Implementation of FxBenchmarkObligationDefault  ***********************/
	class FxBenchmarkObligationDefaultImpl implements FxBenchmarkObligationDefault {
		private final Boolean benchmarkObligationDefaultIsApplicable;
		private final FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		private final SpecifiedValueEnum specifiedValue;
		private final EscrowArrangement escrowArrangement;
		
		protected FxBenchmarkObligationDefaultImpl(FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder builder) {
			this.benchmarkObligationDefaultIsApplicable = builder.getBenchmarkObligationDefaultIsApplicable();
			this.localSubstituteProvisionType = builder.getLocalSubstituteProvisionType();
			this.specifiedValue = builder.getSpecifiedValue();
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("benchmarkObligationDefaultIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("benchmarkObligationDefaultIsApplicable")
		public Boolean getBenchmarkObligationDefaultIsApplicable() {
			return benchmarkObligationDefaultIsApplicable;
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
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		public FxBenchmarkObligationDefault build() {
			return this;
		}
		
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder toBuilder() {
			FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder builder) {
			ofNullable(getBenchmarkObligationDefaultIsApplicable()).ifPresent(builder::setBenchmarkObligationDefaultIsApplicable);
			ofNullable(getLocalSubstituteProvisionType()).ifPresent(builder::setLocalSubstituteProvisionType);
			ofNullable(getSpecifiedValue()).ifPresent(builder::setSpecifiedValue);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBenchmarkObligationDefault _that = getType().cast(o);
		
			if (!Objects.equals(benchmarkObligationDefaultIsApplicable, _that.getBenchmarkObligationDefaultIsApplicable())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(specifiedValue, _that.getSpecifiedValue())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (benchmarkObligationDefaultIsApplicable != null ? benchmarkObligationDefaultIsApplicable.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedValue != null ? specifiedValue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBenchmarkObligationDefault {" +
				"benchmarkObligationDefaultIsApplicable=" + this.benchmarkObligationDefaultIsApplicable + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"specifiedValue=" + this.specifiedValue + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}

	/*********************** Builder Implementation of FxBenchmarkObligationDefault  ***********************/
	class FxBenchmarkObligationDefaultBuilderImpl implements FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder {
	
		protected Boolean benchmarkObligationDefaultIsApplicable;
		protected FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		protected SpecifiedValueEnum specifiedValue;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		
		@Override
		@RosettaAttribute("benchmarkObligationDefaultIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("benchmarkObligationDefaultIsApplicable")
		public Boolean getBenchmarkObligationDefaultIsApplicable() {
			return benchmarkObligationDefaultIsApplicable;
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
		
		@RosettaAttribute("benchmarkObligationDefaultIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("benchmarkObligationDefaultIsApplicable")
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setBenchmarkObligationDefaultIsApplicable(Boolean _benchmarkObligationDefaultIsApplicable) {
			this.benchmarkObligationDefaultIsApplicable = _benchmarkObligationDefaultIsApplicable == null ? null : _benchmarkObligationDefaultIsApplicable;
			return this;
		}
		
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localSubstituteProvisionType")
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum _localSubstituteProvisionType) {
			this.localSubstituteProvisionType = _localSubstituteProvisionType == null ? null : _localSubstituteProvisionType;
			return this;
		}
		
		@RosettaAttribute("specifiedValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specifiedValue")
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setSpecifiedValue(SpecifiedValueEnum _specifiedValue) {
			this.specifiedValue = _specifiedValue == null ? null : _specifiedValue;
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@Override
		public FxBenchmarkObligationDefault build() {
			return new FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultImpl(this);
		}
		
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder prune() {
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBenchmarkObligationDefaultIsApplicable()!=null) return true;
			if (getLocalSubstituteProvisionType()!=null) return true;
			if (getSpecifiedValue()!=null) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder o = (FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder) other;
			
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			
			merger.mergeBasic(getBenchmarkObligationDefaultIsApplicable(), o.getBenchmarkObligationDefaultIsApplicable(), this::setBenchmarkObligationDefaultIsApplicable);
			merger.mergeBasic(getLocalSubstituteProvisionType(), o.getLocalSubstituteProvisionType(), this::setLocalSubstituteProvisionType);
			merger.mergeBasic(getSpecifiedValue(), o.getSpecifiedValue(), this::setSpecifiedValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBenchmarkObligationDefault _that = getType().cast(o);
		
			if (!Objects.equals(benchmarkObligationDefaultIsApplicable, _that.getBenchmarkObligationDefaultIsApplicable())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(specifiedValue, _that.getSpecifiedValue())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (benchmarkObligationDefaultIsApplicable != null ? benchmarkObligationDefaultIsApplicable.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedValue != null ? specifiedValue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBenchmarkObligationDefaultBuilder {" +
				"benchmarkObligationDefaultIsApplicable=" + this.benchmarkObligationDefaultIsApplicable + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"specifiedValue=" + this.specifiedValue + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}
}
