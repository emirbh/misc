package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.GeneralNonTransferabilityMeta;
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
 */
@RosettaDataType(value="GeneralNonTransferability", builder=GeneralNonTransferability.GeneralNonTransferabilityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="GeneralNonTransferability", model="cdm", builder=GeneralNonTransferability.GeneralNonTransferabilityBuilderImpl.class, version="6.23.0")
public interface GeneralNonTransferability extends RosettaModelObject {

	GeneralNonTransferabilityMeta metaData = new GeneralNonTransferabilityMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getGeneralNonTransferabilityIsApplicable();
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
	 * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
	 */
	ValuationPostponement getMaximumDaysOfDisruption();
	NonDeliverableSubstitute getNonDeliverableSubstitute();
	/**
	 * Refers to the segregation deposit procedure parties may want to commmit into during the time a Disruption Event is effective
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.2.(c).(iv)"
	 *
	 * Provision 
	 *
	 */
	EscrowArrangement getEscrowArrangement();

	/*********************** Build Methods  ***********************/
	GeneralNonTransferability build();
	
	GeneralNonTransferability.GeneralNonTransferabilityBuilder toBuilder();
	
	static GeneralNonTransferability.GeneralNonTransferabilityBuilder builder() {
		return new GeneralNonTransferability.GeneralNonTransferabilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GeneralNonTransferability> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GeneralNonTransferability> getType() {
		return GeneralNonTransferability.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("generalNonTransferabilityIsApplicable"), Boolean.class, getGeneralNonTransferabilityIsApplicable(), this);
		processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
		processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.class, getMaximumDaysOfDisruption());
		processRosetta(path.newSubPath("nonDeliverableSubstitute"), processor, NonDeliverableSubstitute.class, getNonDeliverableSubstitute());
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GeneralNonTransferabilityBuilder extends GeneralNonTransferability, RosettaModelObjectBuilder {
		ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption();
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getOrCreateNonDeliverableSubstitute();
		@Override
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getNonDeliverableSubstitute();
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		GeneralNonTransferability.GeneralNonTransferabilityBuilder setGeneralNonTransferabilityIsApplicable(Boolean generalNonTransferabilityIsApplicable);
		GeneralNonTransferability.GeneralNonTransferabilityBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum localSubstituteProvisionType);
		GeneralNonTransferability.GeneralNonTransferabilityBuilder setMaximumDaysOfDisruption(ValuationPostponement maximumDaysOfDisruption);
		GeneralNonTransferability.GeneralNonTransferabilityBuilder setNonDeliverableSubstitute(NonDeliverableSubstitute nonDeliverableSubstitute);
		GeneralNonTransferability.GeneralNonTransferabilityBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("generalNonTransferabilityIsApplicable"), Boolean.class, getGeneralNonTransferabilityIsApplicable(), this);
			processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
			processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getMaximumDaysOfDisruption());
			processRosetta(path.newSubPath("nonDeliverableSubstitute"), processor, NonDeliverableSubstitute.NonDeliverableSubstituteBuilder.class, getNonDeliverableSubstitute());
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
		}
		

		GeneralNonTransferability.GeneralNonTransferabilityBuilder prune();
	}

	/*********************** Immutable Implementation of GeneralNonTransferability  ***********************/
	class GeneralNonTransferabilityImpl implements GeneralNonTransferability {
		private final Boolean generalNonTransferabilityIsApplicable;
		private final FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		private final ValuationPostponement maximumDaysOfDisruption;
		private final NonDeliverableSubstitute nonDeliverableSubstitute;
		private final EscrowArrangement escrowArrangement;
		
		protected GeneralNonTransferabilityImpl(GeneralNonTransferability.GeneralNonTransferabilityBuilder builder) {
			this.generalNonTransferabilityIsApplicable = builder.getGeneralNonTransferabilityIsApplicable();
			this.localSubstituteProvisionType = builder.getLocalSubstituteProvisionType();
			this.maximumDaysOfDisruption = ofNullable(builder.getMaximumDaysOfDisruption()).map(f->f.build()).orElse(null);
			this.nonDeliverableSubstitute = ofNullable(builder.getNonDeliverableSubstitute()).map(f->f.build()).orElse(null);
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("generalNonTransferabilityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("generalNonTransferabilityIsApplicable")
		public Boolean getGeneralNonTransferabilityIsApplicable() {
			return generalNonTransferabilityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localSubstituteProvisionType")
		public FxSubstitutionProvisionTypeEnum getLocalSubstituteProvisionType() {
			return localSubstituteProvisionType;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSubstitute")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonDeliverableSubstitute")
		public NonDeliverableSubstitute getNonDeliverableSubstitute() {
			return nonDeliverableSubstitute;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		public GeneralNonTransferability build() {
			return this;
		}
		
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder toBuilder() {
			GeneralNonTransferability.GeneralNonTransferabilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GeneralNonTransferability.GeneralNonTransferabilityBuilder builder) {
			ofNullable(getGeneralNonTransferabilityIsApplicable()).ifPresent(builder::setGeneralNonTransferabilityIsApplicable);
			ofNullable(getLocalSubstituteProvisionType()).ifPresent(builder::setLocalSubstituteProvisionType);
			ofNullable(getMaximumDaysOfDisruption()).ifPresent(builder::setMaximumDaysOfDisruption);
			ofNullable(getNonDeliverableSubstitute()).ifPresent(builder::setNonDeliverableSubstitute);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralNonTransferability _that = getType().cast(o);
		
			if (!Objects.equals(generalNonTransferabilityIsApplicable, _that.getGeneralNonTransferabilityIsApplicable())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			if (!Objects.equals(nonDeliverableSubstitute, _that.getNonDeliverableSubstitute())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (generalNonTransferabilityIsApplicable != null ? generalNonTransferabilityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSubstitute != null ? nonDeliverableSubstitute.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralNonTransferability {" +
				"generalNonTransferabilityIsApplicable=" + this.generalNonTransferabilityIsApplicable + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"nonDeliverableSubstitute=" + this.nonDeliverableSubstitute + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}

	/*********************** Builder Implementation of GeneralNonTransferability  ***********************/
	class GeneralNonTransferabilityBuilderImpl implements GeneralNonTransferability.GeneralNonTransferabilityBuilder {
	
		protected Boolean generalNonTransferabilityIsApplicable;
		protected FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		protected ValuationPostponement.ValuationPostponementBuilder maximumDaysOfDisruption;
		protected NonDeliverableSubstitute.NonDeliverableSubstituteBuilder nonDeliverableSubstitute;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		
		@Override
		@RosettaAttribute("generalNonTransferabilityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("generalNonTransferabilityIsApplicable")
		public Boolean getGeneralNonTransferabilityIsApplicable() {
			return generalNonTransferabilityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localSubstituteProvisionType")
		public FxSubstitutionProvisionTypeEnum getLocalSubstituteProvisionType() {
			return localSubstituteProvisionType;
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
		
		@Override
		@RosettaAttribute("nonDeliverableSubstitute")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonDeliverableSubstitute")
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getNonDeliverableSubstitute() {
			return nonDeliverableSubstitute;
		}
		
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getOrCreateNonDeliverableSubstitute() {
			NonDeliverableSubstitute.NonDeliverableSubstituteBuilder result;
			if (nonDeliverableSubstitute!=null) {
				result = nonDeliverableSubstitute;
			}
			else {
				result = nonDeliverableSubstitute = NonDeliverableSubstitute.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("generalNonTransferabilityIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("generalNonTransferabilityIsApplicable")
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder setGeneralNonTransferabilityIsApplicable(Boolean _generalNonTransferabilityIsApplicable) {
			this.generalNonTransferabilityIsApplicable = _generalNonTransferabilityIsApplicable == null ? null : _generalNonTransferabilityIsApplicable;
			return this;
		}
		
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localSubstituteProvisionType")
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum _localSubstituteProvisionType) {
			this.localSubstituteProvisionType = _localSubstituteProvisionType == null ? null : _localSubstituteProvisionType;
			return this;
		}
		
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder setMaximumDaysOfDisruption(ValuationPostponement _maximumDaysOfDisruption) {
			this.maximumDaysOfDisruption = _maximumDaysOfDisruption == null ? null : _maximumDaysOfDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonDeliverableSubstitute")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonDeliverableSubstitute")
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder setNonDeliverableSubstitute(NonDeliverableSubstitute _nonDeliverableSubstitute) {
			this.nonDeliverableSubstitute = _nonDeliverableSubstitute == null ? null : _nonDeliverableSubstitute.toBuilder();
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@Override
		public GeneralNonTransferability build() {
			return new GeneralNonTransferability.GeneralNonTransferabilityImpl(this);
		}
		
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder prune() {
			if (maximumDaysOfDisruption!=null && !maximumDaysOfDisruption.prune().hasData()) maximumDaysOfDisruption = null;
			if (nonDeliverableSubstitute!=null && !nonDeliverableSubstitute.prune().hasData()) nonDeliverableSubstitute = null;
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGeneralNonTransferabilityIsApplicable()!=null) return true;
			if (getLocalSubstituteProvisionType()!=null) return true;
			if (getMaximumDaysOfDisruption()!=null && getMaximumDaysOfDisruption().hasData()) return true;
			if (getNonDeliverableSubstitute()!=null && getNonDeliverableSubstitute().hasData()) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GeneralNonTransferability.GeneralNonTransferabilityBuilder o = (GeneralNonTransferability.GeneralNonTransferabilityBuilder) other;
			
			merger.mergeRosetta(getMaximumDaysOfDisruption(), o.getMaximumDaysOfDisruption(), this::setMaximumDaysOfDisruption);
			merger.mergeRosetta(getNonDeliverableSubstitute(), o.getNonDeliverableSubstitute(), this::setNonDeliverableSubstitute);
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			
			merger.mergeBasic(getGeneralNonTransferabilityIsApplicable(), o.getGeneralNonTransferabilityIsApplicable(), this::setGeneralNonTransferabilityIsApplicable);
			merger.mergeBasic(getLocalSubstituteProvisionType(), o.getLocalSubstituteProvisionType(), this::setLocalSubstituteProvisionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralNonTransferability _that = getType().cast(o);
		
			if (!Objects.equals(generalNonTransferabilityIsApplicable, _that.getGeneralNonTransferabilityIsApplicable())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			if (!Objects.equals(nonDeliverableSubstitute, _that.getNonDeliverableSubstitute())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (generalNonTransferabilityIsApplicable != null ? generalNonTransferabilityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSubstitute != null ? nonDeliverableSubstitute.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralNonTransferabilityBuilder {" +
				"generalNonTransferabilityIsApplicable=" + this.generalNonTransferabilityIsApplicable + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"nonDeliverableSubstitute=" + this.nonDeliverableSubstitute + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}
}
