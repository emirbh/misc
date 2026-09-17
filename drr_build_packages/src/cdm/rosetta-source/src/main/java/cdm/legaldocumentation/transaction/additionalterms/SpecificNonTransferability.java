package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.SpecificNonTransferabilityMeta;
import cdm.observable.asset.ValuationPostponement;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 6.23.0
 */
@RosettaDataType(value="SpecificNonTransferability", builder=SpecificNonTransferability.SpecificNonTransferabilityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SpecificNonTransferability", model="cdm", builder=SpecificNonTransferability.SpecificNonTransferabilityBuilderImpl.class, version="6.23.0")
public interface SpecificNonTransferability extends RosettaModelObject {

	SpecificNonTransferabilityMeta metaData = new SpecificNonTransferabilityMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getSpecificNonTransferabilityIsApplicable();
	List<String> getRelevantClass();
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
	ValuationPostponement getMaximumDaysOfDisruption();
	NonDeliverableSubstitute getNonDeliverableSubstitute();
	/**
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
	SpecificNonTransferability build();
	
	SpecificNonTransferability.SpecificNonTransferabilityBuilder toBuilder();
	
	static SpecificNonTransferability.SpecificNonTransferabilityBuilder builder() {
		return new SpecificNonTransferability.SpecificNonTransferabilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpecificNonTransferability> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpecificNonTransferability> getType() {
		return SpecificNonTransferability.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("specificNonTransferabilityIsApplicable"), Boolean.class, getSpecificNonTransferabilityIsApplicable(), this);
		processor.processBasic(path.newSubPath("relevantClass"), String.class, getRelevantClass(), this);
		processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
		processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.class, getMaximumDaysOfDisruption());
		processRosetta(path.newSubPath("nonDeliverableSubstitute"), processor, NonDeliverableSubstitute.class, getNonDeliverableSubstitute());
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpecificNonTransferabilityBuilder extends SpecificNonTransferability, RosettaModelObjectBuilder {
		ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption();
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getOrCreateNonDeliverableSubstitute();
		@Override
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getNonDeliverableSubstitute();
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		SpecificNonTransferability.SpecificNonTransferabilityBuilder setSpecificNonTransferabilityIsApplicable(Boolean specificNonTransferabilityIsApplicable);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder addRelevantClass(String relevantClass);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder addRelevantClass(String relevantClass, int idx);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder addRelevantClass(List<String> relevantClass);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder setRelevantClass(List<String> relevantClass);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum localSubstituteProvisionType);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder setMaximumDaysOfDisruption(ValuationPostponement maximumDaysOfDisruption);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder setNonDeliverableSubstitute(NonDeliverableSubstitute nonDeliverableSubstitute);
		SpecificNonTransferability.SpecificNonTransferabilityBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("specificNonTransferabilityIsApplicable"), Boolean.class, getSpecificNonTransferabilityIsApplicable(), this);
			processor.processBasic(path.newSubPath("relevantClass"), String.class, getRelevantClass(), this);
			processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
			processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getMaximumDaysOfDisruption());
			processRosetta(path.newSubPath("nonDeliverableSubstitute"), processor, NonDeliverableSubstitute.NonDeliverableSubstituteBuilder.class, getNonDeliverableSubstitute());
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
		}
		

		SpecificNonTransferability.SpecificNonTransferabilityBuilder prune();
	}

	/*********************** Immutable Implementation of SpecificNonTransferability  ***********************/
	class SpecificNonTransferabilityImpl implements SpecificNonTransferability {
		private final Boolean specificNonTransferabilityIsApplicable;
		private final List<String> relevantClass;
		private final FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		private final ValuationPostponement maximumDaysOfDisruption;
		private final NonDeliverableSubstitute nonDeliverableSubstitute;
		private final EscrowArrangement escrowArrangement;
		
		protected SpecificNonTransferabilityImpl(SpecificNonTransferability.SpecificNonTransferabilityBuilder builder) {
			this.specificNonTransferabilityIsApplicable = builder.getSpecificNonTransferabilityIsApplicable();
			this.relevantClass = ofNullable(builder.getRelevantClass()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.localSubstituteProvisionType = builder.getLocalSubstituteProvisionType();
			this.maximumDaysOfDisruption = ofNullable(builder.getMaximumDaysOfDisruption()).map(f->f.build()).orElse(null);
			this.nonDeliverableSubstitute = ofNullable(builder.getNonDeliverableSubstitute()).map(f->f.build()).orElse(null);
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("specificNonTransferabilityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specificNonTransferabilityIsApplicable")
		public Boolean getSpecificNonTransferabilityIsApplicable() {
			return specificNonTransferabilityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("relevantClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relevantClass")
		public List<String> getRelevantClass() {
			return relevantClass;
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
		public SpecificNonTransferability build() {
			return this;
		}
		
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder toBuilder() {
			SpecificNonTransferability.SpecificNonTransferabilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecificNonTransferability.SpecificNonTransferabilityBuilder builder) {
			ofNullable(getSpecificNonTransferabilityIsApplicable()).ifPresent(builder::setSpecificNonTransferabilityIsApplicable);
			ofNullable(getRelevantClass()).ifPresent(builder::setRelevantClass);
			ofNullable(getLocalSubstituteProvisionType()).ifPresent(builder::setLocalSubstituteProvisionType);
			ofNullable(getMaximumDaysOfDisruption()).ifPresent(builder::setMaximumDaysOfDisruption);
			ofNullable(getNonDeliverableSubstitute()).ifPresent(builder::setNonDeliverableSubstitute);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecificNonTransferability _that = getType().cast(o);
		
			if (!Objects.equals(specificNonTransferabilityIsApplicable, _that.getSpecificNonTransferabilityIsApplicable())) return false;
			if (!ListEquals.listEquals(relevantClass, _that.getRelevantClass())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			if (!Objects.equals(nonDeliverableSubstitute, _that.getNonDeliverableSubstitute())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specificNonTransferabilityIsApplicable != null ? specificNonTransferabilityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantClass != null ? relevantClass.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSubstitute != null ? nonDeliverableSubstitute.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecificNonTransferability {" +
				"specificNonTransferabilityIsApplicable=" + this.specificNonTransferabilityIsApplicable + ", " +
				"relevantClass=" + this.relevantClass + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"nonDeliverableSubstitute=" + this.nonDeliverableSubstitute + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}

	/*********************** Builder Implementation of SpecificNonTransferability  ***********************/
	class SpecificNonTransferabilityBuilderImpl implements SpecificNonTransferability.SpecificNonTransferabilityBuilder {
	
		protected Boolean specificNonTransferabilityIsApplicable;
		protected List<String> relevantClass = new ArrayList<>();
		protected FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		protected ValuationPostponement.ValuationPostponementBuilder maximumDaysOfDisruption;
		protected NonDeliverableSubstitute.NonDeliverableSubstituteBuilder nonDeliverableSubstitute;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		
		@Override
		@RosettaAttribute("specificNonTransferabilityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specificNonTransferabilityIsApplicable")
		public Boolean getSpecificNonTransferabilityIsApplicable() {
			return specificNonTransferabilityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("relevantClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relevantClass")
		public List<String> getRelevantClass() {
			return relevantClass;
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
		
		@RosettaAttribute("specificNonTransferabilityIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("specificNonTransferabilityIsApplicable")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder setSpecificNonTransferabilityIsApplicable(Boolean _specificNonTransferabilityIsApplicable) {
			this.specificNonTransferabilityIsApplicable = _specificNonTransferabilityIsApplicable == null ? null : _specificNonTransferabilityIsApplicable;
			return this;
		}
		
		@RosettaAttribute("relevantClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relevantClass")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder addRelevantClass(String _relevantClass) {
			if (_relevantClass != null) {
				this.relevantClass.add(_relevantClass);
			}
			return this;
		}
		
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder addRelevantClass(String _relevantClass, int idx) {
			getIndex(this.relevantClass, idx, () -> _relevantClass);
			return this;
		}
		
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder addRelevantClass(List<String> relevantClasss) {
			if (relevantClasss != null) {
				for (final String toAdd : relevantClasss) {
					this.relevantClass.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("relevantClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relevantClass")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder setRelevantClass(List<String> relevantClasss) {
			if (relevantClasss == null) {
				this.relevantClass = new ArrayList<>();
			} else {
				this.relevantClass = relevantClasss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("localSubstituteProvisionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localSubstituteProvisionType")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum _localSubstituteProvisionType) {
			this.localSubstituteProvisionType = _localSubstituteProvisionType == null ? null : _localSubstituteProvisionType;
			return this;
		}
		
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder setMaximumDaysOfDisruption(ValuationPostponement _maximumDaysOfDisruption) {
			this.maximumDaysOfDisruption = _maximumDaysOfDisruption == null ? null : _maximumDaysOfDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonDeliverableSubstitute")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonDeliverableSubstitute")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder setNonDeliverableSubstitute(NonDeliverableSubstitute _nonDeliverableSubstitute) {
			this.nonDeliverableSubstitute = _nonDeliverableSubstitute == null ? null : _nonDeliverableSubstitute.toBuilder();
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@Override
		public SpecificNonTransferability build() {
			return new SpecificNonTransferability.SpecificNonTransferabilityImpl(this);
		}
		
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder prune() {
			if (maximumDaysOfDisruption!=null && !maximumDaysOfDisruption.prune().hasData()) maximumDaysOfDisruption = null;
			if (nonDeliverableSubstitute!=null && !nonDeliverableSubstitute.prune().hasData()) nonDeliverableSubstitute = null;
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpecificNonTransferabilityIsApplicable()!=null) return true;
			if (getRelevantClass()!=null && !getRelevantClass().isEmpty()) return true;
			if (getLocalSubstituteProvisionType()!=null) return true;
			if (getMaximumDaysOfDisruption()!=null && getMaximumDaysOfDisruption().hasData()) return true;
			if (getNonDeliverableSubstitute()!=null && getNonDeliverableSubstitute().hasData()) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecificNonTransferability.SpecificNonTransferabilityBuilder o = (SpecificNonTransferability.SpecificNonTransferabilityBuilder) other;
			
			merger.mergeRosetta(getMaximumDaysOfDisruption(), o.getMaximumDaysOfDisruption(), this::setMaximumDaysOfDisruption);
			merger.mergeRosetta(getNonDeliverableSubstitute(), o.getNonDeliverableSubstitute(), this::setNonDeliverableSubstitute);
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			
			merger.mergeBasic(getSpecificNonTransferabilityIsApplicable(), o.getSpecificNonTransferabilityIsApplicable(), this::setSpecificNonTransferabilityIsApplicable);
			merger.mergeBasic(getRelevantClass(), o.getRelevantClass(), (Consumer<String>) this::addRelevantClass);
			merger.mergeBasic(getLocalSubstituteProvisionType(), o.getLocalSubstituteProvisionType(), this::setLocalSubstituteProvisionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecificNonTransferability _that = getType().cast(o);
		
			if (!Objects.equals(specificNonTransferabilityIsApplicable, _that.getSpecificNonTransferabilityIsApplicable())) return false;
			if (!ListEquals.listEquals(relevantClass, _that.getRelevantClass())) return false;
			if (!Objects.equals(localSubstituteProvisionType, _that.getLocalSubstituteProvisionType())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			if (!Objects.equals(nonDeliverableSubstitute, _that.getNonDeliverableSubstitute())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specificNonTransferabilityIsApplicable != null ? specificNonTransferabilityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantClass != null ? relevantClass.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSubstitute != null ? nonDeliverableSubstitute.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecificNonTransferabilityBuilder {" +
				"specificNonTransferabilityIsApplicable=" + this.specificNonTransferabilityIsApplicable + ", " +
				"relevantClass=" + this.relevantClass + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"nonDeliverableSubstitute=" + this.nonDeliverableSubstitute + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}
}
