package cdm.legaldocumentation.transaction.additionalterms;

import cdm.base.math.Quantity;
import cdm.legaldocumentation.transaction.additionalterms.meta.SpecificInconvertibilityMeta;
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
@RosettaDataType(value="SpecificInconvertibility", builder=SpecificInconvertibility.SpecificInconvertibilityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SpecificInconvertibility", model="cdm", builder=SpecificInconvertibility.SpecificInconvertibilityBuilderImpl.class, version="6.23.0")
public interface SpecificInconvertibility extends RosettaModelObject {

	SpecificInconvertibilityMeta metaData = new SpecificInconvertibilityMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getSpecificInconvertibilityIsApplicable();
	Quantity getMinimumAmount();
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
	SpecificInconvertibility build();
	
	SpecificInconvertibility.SpecificInconvertibilityBuilder toBuilder();
	
	static SpecificInconvertibility.SpecificInconvertibilityBuilder builder() {
		return new SpecificInconvertibility.SpecificInconvertibilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpecificInconvertibility> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpecificInconvertibility> getType() {
		return SpecificInconvertibility.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("specificInconvertibilityIsApplicable"), Boolean.class, getSpecificInconvertibilityIsApplicable(), this);
		processRosetta(path.newSubPath("minimumAmount"), processor, Quantity.class, getMinimumAmount());
		processor.processBasic(path.newSubPath("relevantClass"), String.class, getRelevantClass(), this);
		processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
		processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.class, getMaximumDaysOfDisruption());
		processRosetta(path.newSubPath("nonDeliverableSubstitute"), processor, NonDeliverableSubstitute.class, getNonDeliverableSubstitute());
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpecificInconvertibilityBuilder extends SpecificInconvertibility, RosettaModelObjectBuilder {
		Quantity.QuantityBuilder getOrCreateMinimumAmount();
		@Override
		Quantity.QuantityBuilder getMinimumAmount();
		ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption();
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getOrCreateNonDeliverableSubstitute();
		@Override
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder getNonDeliverableSubstitute();
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		SpecificInconvertibility.SpecificInconvertibilityBuilder setSpecificInconvertibilityIsApplicable(Boolean specificInconvertibilityIsApplicable);
		SpecificInconvertibility.SpecificInconvertibilityBuilder setMinimumAmount(Quantity minimumAmount);
		SpecificInconvertibility.SpecificInconvertibilityBuilder addRelevantClass(String relevantClass);
		SpecificInconvertibility.SpecificInconvertibilityBuilder addRelevantClass(String relevantClass, int idx);
		SpecificInconvertibility.SpecificInconvertibilityBuilder addRelevantClass(List<String> relevantClass);
		SpecificInconvertibility.SpecificInconvertibilityBuilder setRelevantClass(List<String> relevantClass);
		SpecificInconvertibility.SpecificInconvertibilityBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum localSubstituteProvisionType);
		SpecificInconvertibility.SpecificInconvertibilityBuilder setMaximumDaysOfDisruption(ValuationPostponement maximumDaysOfDisruption);
		SpecificInconvertibility.SpecificInconvertibilityBuilder setNonDeliverableSubstitute(NonDeliverableSubstitute nonDeliverableSubstitute);
		SpecificInconvertibility.SpecificInconvertibilityBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("specificInconvertibilityIsApplicable"), Boolean.class, getSpecificInconvertibilityIsApplicable(), this);
			processRosetta(path.newSubPath("minimumAmount"), processor, Quantity.QuantityBuilder.class, getMinimumAmount());
			processor.processBasic(path.newSubPath("relevantClass"), String.class, getRelevantClass(), this);
			processor.processBasic(path.newSubPath("localSubstituteProvisionType"), FxSubstitutionProvisionTypeEnum.class, getLocalSubstituteProvisionType(), this);
			processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getMaximumDaysOfDisruption());
			processRosetta(path.newSubPath("nonDeliverableSubstitute"), processor, NonDeliverableSubstitute.NonDeliverableSubstituteBuilder.class, getNonDeliverableSubstitute());
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
		}
		

		SpecificInconvertibility.SpecificInconvertibilityBuilder prune();
	}

	/*********************** Immutable Implementation of SpecificInconvertibility  ***********************/
	class SpecificInconvertibilityImpl implements SpecificInconvertibility {
		private final Boolean specificInconvertibilityIsApplicable;
		private final Quantity minimumAmount;
		private final List<String> relevantClass;
		private final FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		private final ValuationPostponement maximumDaysOfDisruption;
		private final NonDeliverableSubstitute nonDeliverableSubstitute;
		private final EscrowArrangement escrowArrangement;
		
		protected SpecificInconvertibilityImpl(SpecificInconvertibility.SpecificInconvertibilityBuilder builder) {
			this.specificInconvertibilityIsApplicable = builder.getSpecificInconvertibilityIsApplicable();
			this.minimumAmount = ofNullable(builder.getMinimumAmount()).map(f->f.build()).orElse(null);
			this.relevantClass = ofNullable(builder.getRelevantClass()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.localSubstituteProvisionType = builder.getLocalSubstituteProvisionType();
			this.maximumDaysOfDisruption = ofNullable(builder.getMaximumDaysOfDisruption()).map(f->f.build()).orElse(null);
			this.nonDeliverableSubstitute = ofNullable(builder.getNonDeliverableSubstitute()).map(f->f.build()).orElse(null);
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("specificInconvertibilityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specificInconvertibilityIsApplicable")
		public Boolean getSpecificInconvertibilityIsApplicable() {
			return specificInconvertibilityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("minimumAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumAmount")
		public Quantity getMinimumAmount() {
			return minimumAmount;
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
		public SpecificInconvertibility build() {
			return this;
		}
		
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder toBuilder() {
			SpecificInconvertibility.SpecificInconvertibilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecificInconvertibility.SpecificInconvertibilityBuilder builder) {
			ofNullable(getSpecificInconvertibilityIsApplicable()).ifPresent(builder::setSpecificInconvertibilityIsApplicable);
			ofNullable(getMinimumAmount()).ifPresent(builder::setMinimumAmount);
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
		
			SpecificInconvertibility _that = getType().cast(o);
		
			if (!Objects.equals(specificInconvertibilityIsApplicable, _that.getSpecificInconvertibilityIsApplicable())) return false;
			if (!Objects.equals(minimumAmount, _that.getMinimumAmount())) return false;
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
			_result = 31 * _result + (specificInconvertibilityIsApplicable != null ? specificInconvertibilityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (minimumAmount != null ? minimumAmount.hashCode() : 0);
			_result = 31 * _result + (relevantClass != null ? relevantClass.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSubstitute != null ? nonDeliverableSubstitute.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecificInconvertibility {" +
				"specificInconvertibilityIsApplicable=" + this.specificInconvertibilityIsApplicable + ", " +
				"minimumAmount=" + this.minimumAmount + ", " +
				"relevantClass=" + this.relevantClass + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"nonDeliverableSubstitute=" + this.nonDeliverableSubstitute + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}

	/*********************** Builder Implementation of SpecificInconvertibility  ***********************/
	class SpecificInconvertibilityBuilderImpl implements SpecificInconvertibility.SpecificInconvertibilityBuilder {
	
		protected Boolean specificInconvertibilityIsApplicable;
		protected Quantity.QuantityBuilder minimumAmount;
		protected List<String> relevantClass = new ArrayList<>();
		protected FxSubstitutionProvisionTypeEnum localSubstituteProvisionType;
		protected ValuationPostponement.ValuationPostponementBuilder maximumDaysOfDisruption;
		protected NonDeliverableSubstitute.NonDeliverableSubstituteBuilder nonDeliverableSubstitute;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		
		@Override
		@RosettaAttribute("specificInconvertibilityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specificInconvertibilityIsApplicable")
		public Boolean getSpecificInconvertibilityIsApplicable() {
			return specificInconvertibilityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("minimumAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumAmount")
		public Quantity.QuantityBuilder getMinimumAmount() {
			return minimumAmount;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateMinimumAmount() {
			Quantity.QuantityBuilder result;
			if (minimumAmount!=null) {
				result = minimumAmount;
			}
			else {
				result = minimumAmount = Quantity.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("specificInconvertibilityIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("specificInconvertibilityIsApplicable")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder setSpecificInconvertibilityIsApplicable(Boolean _specificInconvertibilityIsApplicable) {
			this.specificInconvertibilityIsApplicable = _specificInconvertibilityIsApplicable == null ? null : _specificInconvertibilityIsApplicable;
			return this;
		}
		
		@RosettaAttribute("minimumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumAmount")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder setMinimumAmount(Quantity _minimumAmount) {
			this.minimumAmount = _minimumAmount == null ? null : _minimumAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relevantClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relevantClass")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder addRelevantClass(String _relevantClass) {
			if (_relevantClass != null) {
				this.relevantClass.add(_relevantClass);
			}
			return this;
		}
		
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder addRelevantClass(String _relevantClass, int idx) {
			getIndex(this.relevantClass, idx, () -> _relevantClass);
			return this;
		}
		
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder addRelevantClass(List<String> relevantClasss) {
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
		public SpecificInconvertibility.SpecificInconvertibilityBuilder setRelevantClass(List<String> relevantClasss) {
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
		public SpecificInconvertibility.SpecificInconvertibilityBuilder setLocalSubstituteProvisionType(FxSubstitutionProvisionTypeEnum _localSubstituteProvisionType) {
			this.localSubstituteProvisionType = _localSubstituteProvisionType == null ? null : _localSubstituteProvisionType;
			return this;
		}
		
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder setMaximumDaysOfDisruption(ValuationPostponement _maximumDaysOfDisruption) {
			this.maximumDaysOfDisruption = _maximumDaysOfDisruption == null ? null : _maximumDaysOfDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonDeliverableSubstitute")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonDeliverableSubstitute")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder setNonDeliverableSubstitute(NonDeliverableSubstitute _nonDeliverableSubstitute) {
			this.nonDeliverableSubstitute = _nonDeliverableSubstitute == null ? null : _nonDeliverableSubstitute.toBuilder();
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@Override
		public SpecificInconvertibility build() {
			return new SpecificInconvertibility.SpecificInconvertibilityImpl(this);
		}
		
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder prune() {
			if (minimumAmount!=null && !minimumAmount.prune().hasData()) minimumAmount = null;
			if (maximumDaysOfDisruption!=null && !maximumDaysOfDisruption.prune().hasData()) maximumDaysOfDisruption = null;
			if (nonDeliverableSubstitute!=null && !nonDeliverableSubstitute.prune().hasData()) nonDeliverableSubstitute = null;
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpecificInconvertibilityIsApplicable()!=null) return true;
			if (getMinimumAmount()!=null && getMinimumAmount().hasData()) return true;
			if (getRelevantClass()!=null && !getRelevantClass().isEmpty()) return true;
			if (getLocalSubstituteProvisionType()!=null) return true;
			if (getMaximumDaysOfDisruption()!=null && getMaximumDaysOfDisruption().hasData()) return true;
			if (getNonDeliverableSubstitute()!=null && getNonDeliverableSubstitute().hasData()) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecificInconvertibility.SpecificInconvertibilityBuilder o = (SpecificInconvertibility.SpecificInconvertibilityBuilder) other;
			
			merger.mergeRosetta(getMinimumAmount(), o.getMinimumAmount(), this::setMinimumAmount);
			merger.mergeRosetta(getMaximumDaysOfDisruption(), o.getMaximumDaysOfDisruption(), this::setMaximumDaysOfDisruption);
			merger.mergeRosetta(getNonDeliverableSubstitute(), o.getNonDeliverableSubstitute(), this::setNonDeliverableSubstitute);
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			
			merger.mergeBasic(getSpecificInconvertibilityIsApplicable(), o.getSpecificInconvertibilityIsApplicable(), this::setSpecificInconvertibilityIsApplicable);
			merger.mergeBasic(getRelevantClass(), o.getRelevantClass(), (Consumer<String>) this::addRelevantClass);
			merger.mergeBasic(getLocalSubstituteProvisionType(), o.getLocalSubstituteProvisionType(), this::setLocalSubstituteProvisionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecificInconvertibility _that = getType().cast(o);
		
			if (!Objects.equals(specificInconvertibilityIsApplicable, _that.getSpecificInconvertibilityIsApplicable())) return false;
			if (!Objects.equals(minimumAmount, _that.getMinimumAmount())) return false;
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
			_result = 31 * _result + (specificInconvertibilityIsApplicable != null ? specificInconvertibilityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (minimumAmount != null ? minimumAmount.hashCode() : 0);
			_result = 31 * _result + (relevantClass != null ? relevantClass.hashCode() : 0);
			_result = 31 * _result + (localSubstituteProvisionType != null ? localSubstituteProvisionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSubstitute != null ? nonDeliverableSubstitute.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecificInconvertibilityBuilder {" +
				"specificInconvertibilityIsApplicable=" + this.specificInconvertibilityIsApplicable + ", " +
				"minimumAmount=" + this.minimumAmount + ", " +
				"relevantClass=" + this.relevantClass + ", " +
				"localSubstituteProvisionType=" + this.localSubstituteProvisionType + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"nonDeliverableSubstitute=" + this.nonDeliverableSubstitute + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}
}
