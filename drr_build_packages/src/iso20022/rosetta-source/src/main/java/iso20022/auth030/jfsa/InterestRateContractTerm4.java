package iso20022.auth030.jfsa;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.jfsa.meta.InterestRateContractTerm4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRateContractTerm4", builder=InterestRateContractTerm4.InterestRateContractTerm4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestRateContractTerm4", model="iso20022", builder=InterestRateContractTerm4.InterestRateContractTerm4BuilderImpl.class, version="${project.version}")
public interface InterestRateContractTerm4 extends RosettaModelObject {

	InterestRateContractTerm4Meta metaData = new InterestRateContractTerm4Meta();

	/*********************** Getter Methods  ***********************/
	Frequency13Code getUnit();
	Integer getVal();

	/*********************** Build Methods  ***********************/
	InterestRateContractTerm4 build();
	
	InterestRateContractTerm4.InterestRateContractTerm4Builder toBuilder();
	
	static InterestRateContractTerm4.InterestRateContractTerm4Builder builder() {
		return new InterestRateContractTerm4.InterestRateContractTerm4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateContractTerm4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRateContractTerm4> getType() {
		return InterestRateContractTerm4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unit"), Frequency13Code.class, getUnit(), this);
		processor.processBasic(path.newSubPath("val"), Integer.class, getVal(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateContractTerm4Builder extends InterestRateContractTerm4, RosettaModelObjectBuilder {
		InterestRateContractTerm4.InterestRateContractTerm4Builder setUnit(Frequency13Code unit);
		InterestRateContractTerm4.InterestRateContractTerm4Builder setVal(Integer val);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unit"), Frequency13Code.class, getUnit(), this);
			processor.processBasic(path.newSubPath("val"), Integer.class, getVal(), this);
		}
		

		InterestRateContractTerm4.InterestRateContractTerm4Builder prune();
	}

	/*********************** Immutable Implementation of InterestRateContractTerm4  ***********************/
	class InterestRateContractTerm4Impl implements InterestRateContractTerm4 {
		private final Frequency13Code unit;
		private final Integer val;
		
		protected InterestRateContractTerm4Impl(InterestRateContractTerm4.InterestRateContractTerm4Builder builder) {
			this.unit = builder.getUnit();
			this.val = builder.getVal();
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public Frequency13Code getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("val")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("val")
		public Integer getVal() {
			return val;
		}
		
		@Override
		public InterestRateContractTerm4 build() {
			return this;
		}
		
		@Override
		public InterestRateContractTerm4.InterestRateContractTerm4Builder toBuilder() {
			InterestRateContractTerm4.InterestRateContractTerm4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateContractTerm4.InterestRateContractTerm4Builder builder) {
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getVal()).ifPresent(builder::setVal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateContractTerm4 _that = getType().cast(o);
		
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(val, _that.getVal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (val != null ? val.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateContractTerm4 {" +
				"unit=" + this.unit + ", " +
				"val=" + this.val +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRateContractTerm4  ***********************/
	class InterestRateContractTerm4BuilderImpl implements InterestRateContractTerm4.InterestRateContractTerm4Builder {
	
		protected Frequency13Code unit;
		protected Integer val;
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public Frequency13Code getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("val")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("val")
		public Integer getVal() {
			return val;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unit")
		@Override
		public InterestRateContractTerm4.InterestRateContractTerm4Builder setUnit(Frequency13Code _unit) {
			this.unit = _unit == null ? null : _unit;
			return this;
		}
		
		@RosettaAttribute("val")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("val")
		@Override
		public InterestRateContractTerm4.InterestRateContractTerm4Builder setVal(Integer _val) {
			this.val = _val == null ? null : _val;
			return this;
		}
		
		@Override
		public InterestRateContractTerm4 build() {
			return new InterestRateContractTerm4.InterestRateContractTerm4Impl(this);
		}
		
		@Override
		public InterestRateContractTerm4.InterestRateContractTerm4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateContractTerm4.InterestRateContractTerm4Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnit()!=null) return true;
			if (getVal()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateContractTerm4.InterestRateContractTerm4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRateContractTerm4.InterestRateContractTerm4Builder o = (InterestRateContractTerm4.InterestRateContractTerm4Builder) other;
			
			
			merger.mergeBasic(getUnit(), o.getUnit(), this::setUnit);
			merger.mergeBasic(getVal(), o.getVal(), this::setVal);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateContractTerm4 _that = getType().cast(o);
		
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(val, _that.getVal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (val != null ? val.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateContractTerm4Builder {" +
				"unit=" + this.unit + ", " +
				"val=" + this.val +
			'}';
		}
	}
}
