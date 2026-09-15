package drr.base.trade.price;

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
import drr.base.trade.price.meta.PriceFormatMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="PriceFormat", builder=PriceFormat.PriceFormatBuilderImpl.class, version="7.7.0")
@RuneDataType(value="PriceFormat", model="drr", builder=PriceFormat.PriceFormatBuilderImpl.class, version="7.7.0")
public interface PriceFormat extends RosettaModelObject {

	PriceFormatMeta metaData = new PriceFormatMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getMonetary();
	BigDecimal getDecimal();
	BigDecimal getPercentage();
	BigDecimal getBasis();

	/*********************** Build Methods  ***********************/
	PriceFormat build();
	
	PriceFormat.PriceFormatBuilder toBuilder();
	
	static PriceFormat.PriceFormatBuilder builder() {
		return new PriceFormat.PriceFormatBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceFormat> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PriceFormat> getType() {
		return PriceFormat.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("monetary"), BigDecimal.class, getMonetary(), this);
		processor.processBasic(path.newSubPath("decimal"), BigDecimal.class, getDecimal(), this);
		processor.processBasic(path.newSubPath("percentage"), BigDecimal.class, getPercentage(), this);
		processor.processBasic(path.newSubPath("basis"), BigDecimal.class, getBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceFormatBuilder extends PriceFormat, RosettaModelObjectBuilder {
		PriceFormat.PriceFormatBuilder setMonetary(BigDecimal monetary);
		PriceFormat.PriceFormatBuilder setDecimal(BigDecimal decimal);
		PriceFormat.PriceFormatBuilder setPercentage(BigDecimal percentage);
		PriceFormat.PriceFormatBuilder setBasis(BigDecimal basis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("monetary"), BigDecimal.class, getMonetary(), this);
			processor.processBasic(path.newSubPath("decimal"), BigDecimal.class, getDecimal(), this);
			processor.processBasic(path.newSubPath("percentage"), BigDecimal.class, getPercentage(), this);
			processor.processBasic(path.newSubPath("basis"), BigDecimal.class, getBasis(), this);
		}
		

		PriceFormat.PriceFormatBuilder prune();
	}

	/*********************** Immutable Implementation of PriceFormat  ***********************/
	class PriceFormatImpl implements PriceFormat {
		private final BigDecimal monetary;
		private final BigDecimal decimal;
		private final BigDecimal percentage;
		private final BigDecimal basis;
		
		protected PriceFormatImpl(PriceFormat.PriceFormatBuilder builder) {
			this.monetary = builder.getMonetary();
			this.decimal = builder.getDecimal();
			this.percentage = builder.getPercentage();
			this.basis = builder.getBasis();
		}
		
		@Override
		@RosettaAttribute("monetary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("monetary")
		public BigDecimal getMonetary() {
			return monetary;
		}
		
		@Override
		@RosettaAttribute("decimal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("decimal")
		public BigDecimal getDecimal() {
			return decimal;
		}
		
		@Override
		@RosettaAttribute("percentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentage")
		public BigDecimal getPercentage() {
			return percentage;
		}
		
		@Override
		@RosettaAttribute("basis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basis")
		public BigDecimal getBasis() {
			return basis;
		}
		
		@Override
		public PriceFormat build() {
			return this;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder toBuilder() {
			PriceFormat.PriceFormatBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceFormat.PriceFormatBuilder builder) {
			ofNullable(getMonetary()).ifPresent(builder::setMonetary);
			ofNullable(getDecimal()).ifPresent(builder::setDecimal);
			ofNullable(getPercentage()).ifPresent(builder::setPercentage);
			ofNullable(getBasis()).ifPresent(builder::setBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceFormat _that = getType().cast(o);
		
			if (!Objects.equals(monetary, _that.getMonetary())) return false;
			if (!Objects.equals(decimal, _that.getDecimal())) return false;
			if (!Objects.equals(percentage, _that.getPercentage())) return false;
			if (!Objects.equals(basis, _that.getBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (monetary != null ? monetary.hashCode() : 0);
			_result = 31 * _result + (decimal != null ? decimal.hashCode() : 0);
			_result = 31 * _result + (percentage != null ? percentage.hashCode() : 0);
			_result = 31 * _result + (basis != null ? basis.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceFormat {" +
				"monetary=" + this.monetary + ", " +
				"decimal=" + this.decimal + ", " +
				"percentage=" + this.percentage + ", " +
				"basis=" + this.basis +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceFormat  ***********************/
	class PriceFormatBuilderImpl implements PriceFormat.PriceFormatBuilder {
	
		protected BigDecimal monetary;
		protected BigDecimal decimal;
		protected BigDecimal percentage;
		protected BigDecimal basis;
		
		@Override
		@RosettaAttribute("monetary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("monetary")
		public BigDecimal getMonetary() {
			return monetary;
		}
		
		@Override
		@RosettaAttribute("decimal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("decimal")
		public BigDecimal getDecimal() {
			return decimal;
		}
		
		@Override
		@RosettaAttribute("percentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentage")
		public BigDecimal getPercentage() {
			return percentage;
		}
		
		@Override
		@RosettaAttribute("basis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basis")
		public BigDecimal getBasis() {
			return basis;
		}
		
		@RosettaAttribute("monetary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("monetary")
		@Override
		public PriceFormat.PriceFormatBuilder setMonetary(BigDecimal _monetary) {
			this.monetary = _monetary == null ? null : _monetary;
			return this;
		}
		
		@RosettaAttribute("decimal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("decimal")
		@Override
		public PriceFormat.PriceFormatBuilder setDecimal(BigDecimal _decimal) {
			this.decimal = _decimal == null ? null : _decimal;
			return this;
		}
		
		@RosettaAttribute("percentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("percentage")
		@Override
		public PriceFormat.PriceFormatBuilder setPercentage(BigDecimal _percentage) {
			this.percentage = _percentage == null ? null : _percentage;
			return this;
		}
		
		@RosettaAttribute("basis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basis")
		@Override
		public PriceFormat.PriceFormatBuilder setBasis(BigDecimal _basis) {
			this.basis = _basis == null ? null : _basis;
			return this;
		}
		
		@Override
		public PriceFormat build() {
			return new PriceFormat.PriceFormatImpl(this);
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceFormat.PriceFormatBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMonetary()!=null) return true;
			if (getDecimal()!=null) return true;
			if (getPercentage()!=null) return true;
			if (getBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceFormat.PriceFormatBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceFormat.PriceFormatBuilder o = (PriceFormat.PriceFormatBuilder) other;
			
			
			merger.mergeBasic(getMonetary(), o.getMonetary(), this::setMonetary);
			merger.mergeBasic(getDecimal(), o.getDecimal(), this::setDecimal);
			merger.mergeBasic(getPercentage(), o.getPercentage(), this::setPercentage);
			merger.mergeBasic(getBasis(), o.getBasis(), this::setBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceFormat _that = getType().cast(o);
		
			if (!Objects.equals(monetary, _that.getMonetary())) return false;
			if (!Objects.equals(decimal, _that.getDecimal())) return false;
			if (!Objects.equals(percentage, _that.getPercentage())) return false;
			if (!Objects.equals(basis, _that.getBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (monetary != null ? monetary.hashCode() : 0);
			_result = 31 * _result + (decimal != null ? decimal.hashCode() : 0);
			_result = 31 * _result + (percentage != null ? percentage.hashCode() : 0);
			_result = 31 * _result + (basis != null ? basis.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceFormatBuilder {" +
				"monetary=" + this.monetary + ", " +
				"decimal=" + this.decimal + ", " +
				"percentage=" + this.percentage + ", " +
				"basis=" + this.basis +
			'}';
		}
	}
}
