package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAccrualSettlementPeriodScheduleMeta;
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
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxAccrualSettlementPeriodSchedule", builder=FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualSettlementPeriodSchedule", model="fpml", builder=FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilderImpl.class, version="2.1.1")
public interface FxAccrualSettlementPeriodSchedule extends RosettaModelObject {

	FxAccrualSettlementPeriodScheduleMeta metaData = new FxAccrualSettlementPeriodScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines each settlement period in the tabular/matrix representation of the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines each settlement period in the tabular/matrix representation of the product.
	 *
	 */
	List<? extends FxAccrualSettlementPeriod> getSettlementPeriod();

	/*********************** Build Methods  ***********************/
	FxAccrualSettlementPeriodSchedule build();
	
	FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder toBuilder();
	
	static FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder() {
		return new FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualSettlementPeriodSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualSettlementPeriodSchedule> getType() {
		return FxAccrualSettlementPeriodSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriod"), processor, FxAccrualSettlementPeriod.class, getSettlementPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualSettlementPeriodScheduleBuilder extends FxAccrualSettlementPeriodSchedule, RosettaModelObjectBuilder {
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder getOrCreateSettlementPeriod(int index);
		@Override
		List<? extends FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder> getSettlementPeriod();
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod settlementPeriod);
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod settlementPeriod, int idx);
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriod);
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriod"), processor, FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder.class, getSettlementPeriod());
		}
		

		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualSettlementPeriodSchedule  ***********************/
	class FxAccrualSettlementPeriodScheduleImpl implements FxAccrualSettlementPeriodSchedule {
		private final List<? extends FxAccrualSettlementPeriod> settlementPeriod;
		
		protected FxAccrualSettlementPeriodScheduleImpl(FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder) {
			this.settlementPeriod = ofNullable(builder.getSettlementPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriod")
		public List<? extends FxAccrualSettlementPeriod> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule build() {
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder toBuilder() {
			FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder) {
			ofNullable(getSettlementPeriod()).ifPresent(builder::setSettlementPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriod, _that.getSettlementPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriod != null ? settlementPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodSchedule {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualSettlementPeriodSchedule  ***********************/
	class FxAccrualSettlementPeriodScheduleBuilderImpl implements FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder {
	
		protected List<FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder> settlementPeriod = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriod")
		public List<? extends FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder getOrCreateSettlementPeriod(int index) {
			if (settlementPeriod==null) {
				this.settlementPeriod = new ArrayList<>();
			}
			return getIndex(settlementPeriod, index, () -> {
						FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder newSettlementPeriod = FxAccrualSettlementPeriod.builder();
						return newSettlementPeriod;
					});
		}
		
		@RosettaAttribute("settlementPeriod")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriod")
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod _settlementPeriod) {
			if (_settlementPeriod != null) {
				this.settlementPeriod.add(_settlementPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod _settlementPeriod, int idx) {
			getIndex(this.settlementPeriod, idx, () -> _settlementPeriod.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriods) {
			if (settlementPeriods != null) {
				for (final FxAccrualSettlementPeriod toAdd : settlementPeriods) {
					this.settlementPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriod")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriod")
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriods) {
			if (settlementPeriods == null) {
				this.settlementPeriod = new ArrayList<>();
			} else {
				this.settlementPeriod = settlementPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule build() {
			return new FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleImpl(this);
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder prune() {
			settlementPeriod = settlementPeriod.stream().filter(b->b!=null).<FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriod()!=null && getSettlementPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder o = (FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriod(), o.getSettlementPeriod(), this::getOrCreateSettlementPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriod, _that.getSettlementPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriod != null ? settlementPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodScheduleBuilder {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}
}
