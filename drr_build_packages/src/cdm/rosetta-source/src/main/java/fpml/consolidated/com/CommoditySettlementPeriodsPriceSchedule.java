package fpml.consolidated.com;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.com.meta.CommoditySettlementPeriodsPriceScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The fixed price schedule for electricity that applies to one or more groups of Settlement Periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The fixed price schedule for electricity that applies to one or more groups of Settlement Periods.
 *
 */
@RosettaDataType(value="CommoditySettlementPeriodsPriceSchedule", builder=CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommoditySettlementPeriodsPriceSchedule", model="fpml", builder=CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilderImpl.class, version="2.1.1")
public interface CommoditySettlementPeriodsPriceSchedule extends RosettaModelObject {

	CommoditySettlementPeriodsPriceScheduleMeta metaData = new CommoditySettlementPeriodsPriceScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an electricity transaction, the Fixed Price for a given Calculation Period during the life of the trade which applies to the range(s) of Settlement Periods referenced by settlementPeriods Reference. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an electricity transaction, the Fixed Price for a given Calculation Period during the life of the trade which applies to the range(s) of Settlement Periods referenced by settlementPeriods Reference. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
	 *
	 */
	List<? extends CommodityFixedPrice> getSettlementPeriodsPriceStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The range(s) of Settlement Periods to which the Fixed Price steps apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The range(s) of Settlement Periods to which the Fixed Price steps apply.
	 *
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	CommoditySettlementPeriodsPriceSchedule build();
	
	CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder toBuilder();
	
	static CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder() {
		return new CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySettlementPeriodsPriceSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommoditySettlementPeriodsPriceSchedule> getType() {
		return CommoditySettlementPeriodsPriceSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriodsPriceStep"), processor, CommodityFixedPrice.class, getSettlementPeriodsPriceStep());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySettlementPeriodsPriceScheduleBuilder extends CommoditySettlementPeriodsPriceSchedule, RosettaModelObjectBuilder {
		CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateSettlementPeriodsPriceStep(int index);
		@Override
		List<? extends CommodityFixedPrice.CommodityFixedPriceBuilder> getSettlementPeriodsPriceStep();
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index);
		@Override
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(CommodityFixedPrice settlementPeriodsPriceStep);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(CommodityFixedPrice settlementPeriodsPriceStep, int idx);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(List<? extends CommodityFixedPrice> settlementPeriodsPriceStep);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsPriceStep(List<? extends CommodityFixedPrice> settlementPeriodsPriceStep);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int idx);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriodsPriceStep"), processor, CommodityFixedPrice.CommodityFixedPriceBuilder.class, getSettlementPeriodsPriceStep());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySettlementPeriodsPriceSchedule  ***********************/
	class CommoditySettlementPeriodsPriceScheduleImpl implements CommoditySettlementPeriodsPriceSchedule {
		private final List<? extends CommodityFixedPrice> settlementPeriodsPriceStep;
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected CommoditySettlementPeriodsPriceScheduleImpl(CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder) {
			this.settlementPeriodsPriceStep = ofNullable(builder.getSettlementPeriodsPriceStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceStep")
		public List<? extends CommodityFixedPrice> getSettlementPeriodsPriceStep() {
			return settlementPeriodsPriceStep;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule build() {
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder toBuilder() {
			CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder) {
			ofNullable(getSettlementPeriodsPriceStep()).ifPresent(builder::setSettlementPeriodsPriceStep);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySettlementPeriodsPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsPriceStep, _that.getSettlementPeriodsPriceStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsPriceStep != null ? settlementPeriodsPriceStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySettlementPeriodsPriceSchedule {" +
				"settlementPeriodsPriceStep=" + this.settlementPeriodsPriceStep + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySettlementPeriodsPriceSchedule  ***********************/
	class CommoditySettlementPeriodsPriceScheduleBuilderImpl implements CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder {
	
		protected List<CommodityFixedPrice.CommodityFixedPriceBuilder> settlementPeriodsPriceStep = new ArrayList<>();
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceStep")
		public List<? extends CommodityFixedPrice.CommodityFixedPriceBuilder> getSettlementPeriodsPriceStep() {
			return settlementPeriodsPriceStep;
		}
		
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateSettlementPeriodsPriceStep(int index) {
			if (settlementPeriodsPriceStep==null) {
				this.settlementPeriodsPriceStep = new ArrayList<>();
			}
			return getIndex(settlementPeriodsPriceStep, index, () -> {
						CommodityFixedPrice.CommodityFixedPriceBuilder newSettlementPeriodsPriceStep = CommodityFixedPrice.builder();
						return newSettlementPeriodsPriceStep;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index) {
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			return getIndex(settlementPeriodsReference, index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@RosettaAttribute("settlementPeriodsPriceStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceStep")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(CommodityFixedPrice _settlementPeriodsPriceStep) {
			if (_settlementPeriodsPriceStep != null) {
				this.settlementPeriodsPriceStep.add(_settlementPeriodsPriceStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(CommodityFixedPrice _settlementPeriodsPriceStep, int idx) {
			getIndex(this.settlementPeriodsPriceStep, idx, () -> _settlementPeriodsPriceStep.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(List<? extends CommodityFixedPrice> settlementPeriodsPriceSteps) {
			if (settlementPeriodsPriceSteps != null) {
				for (final CommodityFixedPrice toAdd : settlementPeriodsPriceSteps) {
					this.settlementPeriodsPriceStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsPriceStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceStep")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsPriceStep(List<? extends CommodityFixedPrice> settlementPeriodsPriceSteps) {
			if (settlementPeriodsPriceSteps == null) {
				this.settlementPeriodsPriceStep = new ArrayList<>();
			} else {
				this.settlementPeriodsPriceStep = settlementPeriodsPriceSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference) {
			if (_settlementPeriodsReference != null) {
				this.settlementPeriodsReference.add(_settlementPeriodsReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference, int idx) {
			getIndex(this.settlementPeriodsReference, idx, () -> _settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (final SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null) {
				this.settlementPeriodsReference = new ArrayList<>();
			} else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule build() {
			return new CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleImpl(this);
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder prune() {
			settlementPeriodsPriceStep = settlementPeriodsPriceStep.stream().filter(b->b!=null).<CommodityFixedPrice.CommodityFixedPriceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriodsPriceStep()!=null && getSettlementPeriodsPriceStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder o = (CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsPriceStep(), o.getSettlementPeriodsPriceStep(), this::getOrCreateSettlementPeriodsPriceStep);
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySettlementPeriodsPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsPriceStep, _that.getSettlementPeriodsPriceStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsPriceStep != null ? settlementPeriodsPriceStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySettlementPeriodsPriceScheduleBuilder {" +
				"settlementPeriodsPriceStep=" + this.settlementPeriodsPriceStep + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}
}
