package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.QuantityTerm1__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the notional quantity frequency.
 * @version ${project.version}
 */
@RosettaDataType(value="QuantityTerm1__1", builder=QuantityTerm1__1.QuantityTerm1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="QuantityTerm1__1", model="iso20022", builder=QuantityTerm1__1.QuantityTerm1__1BuilderImpl.class, version="${project.version}")
public interface QuantityTerm1__1 extends RosettaModelObject {

	QuantityTerm1__1Meta metaData = new QuantityTerm1__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Number of units of the financial instrument, that is, the nominal value.
	 */
	BigDecimal getQty();
	/**
	 * Specifies the number of time units (as expressed by the frequency period) that determines the frequency at which periodic dates occur.
	 */
	Integer getVal();
	/**
	 * Unit for the frequency period.
	 */
	Frequency19Code__1 getTmUnit();

	/*********************** Build Methods  ***********************/
	QuantityTerm1__1 build();
	
	QuantityTerm1__1.QuantityTerm1__1Builder toBuilder();
	
	static QuantityTerm1__1.QuantityTerm1__1Builder builder() {
		return new QuantityTerm1__1.QuantityTerm1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuantityTerm1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QuantityTerm1__1> getType() {
		return QuantityTerm1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
		processor.processBasic(path.newSubPath("val"), Integer.class, getVal(), this);
		processor.processBasic(path.newSubPath("tmUnit"), Frequency19Code__1.class, getTmUnit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityTerm1__1Builder extends QuantityTerm1__1, RosettaModelObjectBuilder {
		QuantityTerm1__1.QuantityTerm1__1Builder setQty(BigDecimal qty);
		QuantityTerm1__1.QuantityTerm1__1Builder setVal(Integer val);
		QuantityTerm1__1.QuantityTerm1__1Builder setTmUnit(Frequency19Code__1 tmUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
			processor.processBasic(path.newSubPath("val"), Integer.class, getVal(), this);
			processor.processBasic(path.newSubPath("tmUnit"), Frequency19Code__1.class, getTmUnit(), this);
		}
		

		QuantityTerm1__1.QuantityTerm1__1Builder prune();
	}

	/*********************** Immutable Implementation of QuantityTerm1__1  ***********************/
	class QuantityTerm1__1Impl implements QuantityTerm1__1 {
		private final BigDecimal qty;
		private final Integer val;
		private final Frequency19Code__1 tmUnit;
		
		protected QuantityTerm1__1Impl(QuantityTerm1__1.QuantityTerm1__1Builder builder) {
			this.qty = builder.getQty();
			this.val = builder.getVal();
			this.tmUnit = builder.getTmUnit();
		}
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@Override
		@RosettaAttribute("val")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("val")
		public Integer getVal() {
			return val;
		}
		
		@Override
		@RosettaAttribute("tmUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tmUnit")
		public Frequency19Code__1 getTmUnit() {
			return tmUnit;
		}
		
		@Override
		public QuantityTerm1__1 build() {
			return this;
		}
		
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder toBuilder() {
			QuantityTerm1__1.QuantityTerm1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityTerm1__1.QuantityTerm1__1Builder builder) {
			ofNullable(getQty()).ifPresent(builder::setQty);
			ofNullable(getVal()).ifPresent(builder::setVal);
			ofNullable(getTmUnit()).ifPresent(builder::setTmUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityTerm1__1 _that = getType().cast(o);
		
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(val, _that.getVal())) return false;
			if (!Objects.equals(tmUnit, _that.getTmUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (val != null ? val.hashCode() : 0);
			_result = 31 * _result + (tmUnit != null ? tmUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityTerm1__1 {" +
				"qty=" + this.qty + ", " +
				"val=" + this.val + ", " +
				"tmUnit=" + this.tmUnit +
			'}';
		}
	}

	/*********************** Builder Implementation of QuantityTerm1__1  ***********************/
	class QuantityTerm1__1BuilderImpl implements QuantityTerm1__1.QuantityTerm1__1Builder {
	
		protected BigDecimal qty;
		protected Integer val;
		protected Frequency19Code__1 tmUnit;
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@Override
		@RosettaAttribute("val")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("val")
		public Integer getVal() {
			return val;
		}
		
		@Override
		@RosettaAttribute("tmUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tmUnit")
		public Frequency19Code__1 getTmUnit() {
			return tmUnit;
		}
		
		@RosettaAttribute("qty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("qty")
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder setQty(BigDecimal _qty) {
			this.qty = _qty == null ? null : _qty;
			return this;
		}
		
		@RosettaAttribute("val")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("val")
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder setVal(Integer _val) {
			this.val = _val == null ? null : _val;
			return this;
		}
		
		@RosettaAttribute("tmUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tmUnit")
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder setTmUnit(Frequency19Code__1 _tmUnit) {
			this.tmUnit = _tmUnit == null ? null : _tmUnit;
			return this;
		}
		
		@Override
		public QuantityTerm1__1 build() {
			return new QuantityTerm1__1.QuantityTerm1__1Impl(this);
		}
		
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQty()!=null) return true;
			if (getVal()!=null) return true;
			if (getTmUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityTerm1__1.QuantityTerm1__1Builder o = (QuantityTerm1__1.QuantityTerm1__1Builder) other;
			
			
			merger.mergeBasic(getQty(), o.getQty(), this::setQty);
			merger.mergeBasic(getVal(), o.getVal(), this::setVal);
			merger.mergeBasic(getTmUnit(), o.getTmUnit(), this::setTmUnit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityTerm1__1 _that = getType().cast(o);
		
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(val, _that.getVal())) return false;
			if (!Objects.equals(tmUnit, _that.getTmUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (val != null ? val.hashCode() : 0);
			_result = 31 * _result + (tmUnit != null ? tmUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityTerm1__1Builder {" +
				"qty=" + this.qty + ", " +
				"val=" + this.val + ", " +
				"tmUnit=" + this.tmUnit +
			'}';
		}
	}
}
