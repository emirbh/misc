package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.InterestRateContractTerm4__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes how interest rates are reported.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRateContractTerm4__1", builder=InterestRateContractTerm4__1.InterestRateContractTerm4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestRateContractTerm4__1", model="iso20022", builder=InterestRateContractTerm4__1.InterestRateContractTerm4__1BuilderImpl.class, version="${project.version}")
public interface InterestRateContractTerm4__1 extends RosettaModelObject {

	InterestRateContractTerm4__1Meta metaData = new InterestRateContractTerm4__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unit for the rate basis.
	 */
	Frequency13Code__1 getUnit();
	/**
	 * Specifies the number of time units (as expressed by the payment frequency period) that detemines the frequency at which periodic payment dates occur.
	 */
	Integer getVal();

	/*********************** Build Methods  ***********************/
	InterestRateContractTerm4__1 build();
	
	InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder toBuilder();
	
	static InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder builder() {
		return new InterestRateContractTerm4__1.InterestRateContractTerm4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateContractTerm4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRateContractTerm4__1> getType() {
		return InterestRateContractTerm4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unit"), Frequency13Code__1.class, getUnit(), this);
		processor.processBasic(path.newSubPath("val"), Integer.class, getVal(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateContractTerm4__1Builder extends InterestRateContractTerm4__1, RosettaModelObjectBuilder {
		InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder setUnit(Frequency13Code__1 unit);
		InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder setVal(Integer val);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unit"), Frequency13Code__1.class, getUnit(), this);
			processor.processBasic(path.newSubPath("val"), Integer.class, getVal(), this);
		}
		

		InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder prune();
	}

	/*********************** Immutable Implementation of InterestRateContractTerm4__1  ***********************/
	class InterestRateContractTerm4__1Impl implements InterestRateContractTerm4__1 {
		private final Frequency13Code__1 unit;
		private final Integer val;
		
		protected InterestRateContractTerm4__1Impl(InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder builder) {
			this.unit = builder.getUnit();
			this.val = builder.getVal();
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public Frequency13Code__1 getUnit() {
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
		public InterestRateContractTerm4__1 build() {
			return this;
		}
		
		@Override
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder toBuilder() {
			InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder builder) {
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getVal()).ifPresent(builder::setVal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateContractTerm4__1 _that = getType().cast(o);
		
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
			return "InterestRateContractTerm4__1 {" +
				"unit=" + this.unit + ", " +
				"val=" + this.val +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRateContractTerm4__1  ***********************/
	class InterestRateContractTerm4__1BuilderImpl implements InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder {
	
		protected Frequency13Code__1 unit;
		protected Integer val;
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public Frequency13Code__1 getUnit() {
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
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder setUnit(Frequency13Code__1 _unit) {
			this.unit = _unit == null ? null : _unit;
			return this;
		}
		
		@RosettaAttribute("val")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("val")
		@Override
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder setVal(Integer _val) {
			this.val = _val == null ? null : _val;
			return this;
		}
		
		@Override
		public InterestRateContractTerm4__1 build() {
			return new InterestRateContractTerm4__1.InterestRateContractTerm4__1Impl(this);
		}
		
		@Override
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder prune() {
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
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder o = (InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder) other;
			
			
			merger.mergeBasic(getUnit(), o.getUnit(), this::setUnit);
			merger.mergeBasic(getVal(), o.getVal(), this::setVal);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateContractTerm4__1 _that = getType().cast(o);
		
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
			return "InterestRateContractTerm4__1Builder {" +
				"unit=" + this.unit + ", " +
				"val=" + this.val +
			'}';
		}
	}
}
