package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxTargetSettlementPeriodScheduleMeta;
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
@RosettaDataType(value="FxTargetSettlementPeriodSchedule", builder=FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetSettlementPeriodSchedule", model="fpml", builder=FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilderImpl.class, version="2.1.1")
public interface FxTargetSettlementPeriodSchedule extends RosettaModelObject {

	FxTargetSettlementPeriodScheduleMeta metaData = new FxTargetSettlementPeriodScheduleMeta();

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
	List<? extends FxTargetSettlementPeriod> getSettlementPeriod();

	/*********************** Build Methods  ***********************/
	FxTargetSettlementPeriodSchedule build();
	
	FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder toBuilder();
	
	static FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder() {
		return new FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetSettlementPeriodSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetSettlementPeriodSchedule> getType() {
		return FxTargetSettlementPeriodSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriod"), processor, FxTargetSettlementPeriod.class, getSettlementPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetSettlementPeriodScheduleBuilder extends FxTargetSettlementPeriodSchedule, RosettaModelObjectBuilder {
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder getOrCreateSettlementPeriod(int index);
		@Override
		List<? extends FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder> getSettlementPeriod();
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod settlementPeriod);
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod settlementPeriod, int idx);
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriod);
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriod"), processor, FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder.class, getSettlementPeriod());
		}
		

		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetSettlementPeriodSchedule  ***********************/
	class FxTargetSettlementPeriodScheduleImpl implements FxTargetSettlementPeriodSchedule {
		private final List<? extends FxTargetSettlementPeriod> settlementPeriod;
		
		protected FxTargetSettlementPeriodScheduleImpl(FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder) {
			this.settlementPeriod = ofNullable(builder.getSettlementPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriod")
		public List<? extends FxTargetSettlementPeriod> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule build() {
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder toBuilder() {
			FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder) {
			ofNullable(getSettlementPeriod()).ifPresent(builder::setSettlementPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetSettlementPeriodSchedule _that = getType().cast(o);
		
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
			return "FxTargetSettlementPeriodSchedule {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetSettlementPeriodSchedule  ***********************/
	class FxTargetSettlementPeriodScheduleBuilderImpl implements FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder {
	
		protected List<FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder> settlementPeriod = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriod")
		public List<? extends FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		@Override
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder getOrCreateSettlementPeriod(int index) {
			if (settlementPeriod==null) {
				this.settlementPeriod = new ArrayList<>();
			}
			return getIndex(settlementPeriod, index, () -> {
						FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder newSettlementPeriod = FxTargetSettlementPeriod.builder();
						return newSettlementPeriod;
					});
		}
		
		@RosettaAttribute("settlementPeriod")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriod")
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod _settlementPeriod) {
			if (_settlementPeriod != null) {
				this.settlementPeriod.add(_settlementPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod _settlementPeriod, int idx) {
			getIndex(this.settlementPeriod, idx, () -> _settlementPeriod.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriods) {
			if (settlementPeriods != null) {
				for (final FxTargetSettlementPeriod toAdd : settlementPeriods) {
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
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriods) {
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
		public FxTargetSettlementPeriodSchedule build() {
			return new FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleImpl(this);
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder prune() {
			settlementPeriod = settlementPeriod.stream().filter(b->b!=null).<FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriod()!=null && getSettlementPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder o = (FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriod(), o.getSettlementPeriod(), this::getOrCreateSettlementPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetSettlementPeriodSchedule _that = getType().cast(o);
		
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
			return "FxTargetSettlementPeriodScheduleBuilder {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}
}
