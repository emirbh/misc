package cdm.base.math;

import cdm.base.math.meta.MeasureScheduleMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A set of measures, all in the same unit, where the values are defined through a schedule of steps. The initial value may be defined either as part of the steps, or using the single amount attribute.
 * @version 6.23.0
 */
@RosettaDataType(value="MeasureSchedule", builder=MeasureSchedule.MeasureScheduleBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MeasureSchedule", model="cdm", builder=MeasureSchedule.MeasureScheduleBuilderImpl.class, version="6.23.0")
public interface MeasureSchedule extends MeasureBase {

	MeasureScheduleMeta metaData = new MeasureScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
	 */
	List<? extends DatedValue> getDatedValue();

	/*********************** Build Methods  ***********************/
	MeasureSchedule build();
	
	MeasureSchedule.MeasureScheduleBuilder toBuilder();
	
	static MeasureSchedule.MeasureScheduleBuilder builder() {
		return new MeasureSchedule.MeasureScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MeasureSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MeasureSchedule> getType() {
		return MeasureSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("unit"), processor, UnitType.class, getUnit());
		processRosetta(path.newSubPath("datedValue"), processor, DatedValue.class, getDatedValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MeasureScheduleBuilder extends MeasureSchedule, MeasureBase.MeasureBaseBuilder {
		DatedValue.DatedValueBuilder getOrCreateDatedValue(int index);
		@Override
		List<? extends DatedValue.DatedValueBuilder> getDatedValue();
		@Override
		MeasureSchedule.MeasureScheduleBuilder setValue(BigDecimal value);
		@Override
		MeasureSchedule.MeasureScheduleBuilder setUnit(UnitType unit);
		MeasureSchedule.MeasureScheduleBuilder addDatedValue(DatedValue datedValue);
		MeasureSchedule.MeasureScheduleBuilder addDatedValue(DatedValue datedValue, int idx);
		MeasureSchedule.MeasureScheduleBuilder addDatedValue(List<? extends DatedValue> datedValue);
		MeasureSchedule.MeasureScheduleBuilder setDatedValue(List<? extends DatedValue> datedValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("unit"), processor, UnitType.UnitTypeBuilder.class, getUnit());
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
		}
		

		MeasureSchedule.MeasureScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of MeasureSchedule  ***********************/
	class MeasureScheduleImpl extends MeasureBase.MeasureBaseImpl implements MeasureSchedule {
		private final List<? extends DatedValue> datedValue;
		
		protected MeasureScheduleImpl(MeasureSchedule.MeasureScheduleBuilder builder) {
			super(builder);
			this.datedValue = ofNullable(builder.getDatedValue()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("datedValue")
		public List<? extends DatedValue> getDatedValue() {
			return datedValue;
		}
		
		@Override
		public MeasureSchedule build() {
			return this;
		}
		
		@Override
		public MeasureSchedule.MeasureScheduleBuilder toBuilder() {
			MeasureSchedule.MeasureScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MeasureSchedule.MeasureScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDatedValue()).ifPresent(builder::setDatedValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MeasureSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(datedValue, _that.getDatedValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (datedValue != null ? datedValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MeasureSchedule {" +
				"datedValue=" + this.datedValue +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MeasureSchedule  ***********************/
	class MeasureScheduleBuilderImpl extends MeasureBase.MeasureBaseBuilderImpl implements MeasureSchedule.MeasureScheduleBuilder {
	
		protected List<DatedValue.DatedValueBuilder> datedValue = new ArrayList<>();
		
		@Override
		@RosettaAttribute("datedValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("datedValue")
		public List<? extends DatedValue.DatedValueBuilder> getDatedValue() {
			return datedValue;
		}
		
		@Override
		public DatedValue.DatedValueBuilder getOrCreateDatedValue(int index) {
			if (datedValue==null) {
				this.datedValue = new ArrayList<>();
			}
			return getIndex(datedValue, index, () -> {
						DatedValue.DatedValueBuilder newDatedValue = DatedValue.builder();
						return newDatedValue;
					});
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("value")
		@Override
		public MeasureSchedule.MeasureScheduleBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unit")
		@Override
		public MeasureSchedule.MeasureScheduleBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("datedValue")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("datedValue")
		@Override
		public MeasureSchedule.MeasureScheduleBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public MeasureSchedule.MeasureScheduleBuilder addDatedValue(DatedValue _datedValue, int idx) {
			getIndex(this.datedValue, idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override
		public MeasureSchedule.MeasureScheduleBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("datedValue")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("datedValue")
		@Override
		public MeasureSchedule.MeasureScheduleBuilder setDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues == null) {
				this.datedValue = new ArrayList<>();
			} else {
				this.datedValue = datedValues.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MeasureSchedule build() {
			return new MeasureSchedule.MeasureScheduleImpl(this);
		}
		
		@Override
		public MeasureSchedule.MeasureScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MeasureSchedule.MeasureScheduleBuilder prune() {
			super.prune();
			datedValue = datedValue.stream().filter(b->b!=null).<DatedValue.DatedValueBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDatedValue()!=null && getDatedValue().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MeasureSchedule.MeasureScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MeasureSchedule.MeasureScheduleBuilder o = (MeasureSchedule.MeasureScheduleBuilder) other;
			
			merger.mergeRosetta(getDatedValue(), o.getDatedValue(), this::getOrCreateDatedValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MeasureSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(datedValue, _that.getDatedValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (datedValue != null ? datedValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MeasureScheduleBuilder {" +
				"datedValue=" + this.datedValue +
			'}' + " " + super.toString();
		}
	}
}
