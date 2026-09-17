package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.CreditLimitUtilizationPositionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CreditLimitUtilizationPosition", builder=CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditLimitUtilizationPosition", model="fpml", builder=CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilderImpl.class, version="2.1.1")
public interface CreditLimitUtilizationPosition extends RosettaModelObject {

	CreditLimitUtilizationPositionMeta metaData = new CreditLimitUtilizationPositionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Credit limit utilization attributable to short positions.
	 *
	 */
	BigDecimal getShort();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Credit limit utilization attributable to long positions.
	 *
	 */
	BigDecimal getLong();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Global credit limit utilization amount, agnostic of long/short position direction.
	 *
	 */
	BigDecimal getGlobal();

	/*********************** Build Methods  ***********************/
	CreditLimitUtilizationPosition build();
	
	CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder toBuilder();
	
	static CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder() {
		return new CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitUtilizationPosition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditLimitUtilizationPosition> getType() {
		return CreditLimitUtilizationPosition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("short"), BigDecimal.class, getShort(), this);
		processor.processBasic(path.newSubPath("long"), BigDecimal.class, getLong(), this);
		processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitUtilizationPositionBuilder extends CreditLimitUtilizationPosition, RosettaModelObjectBuilder {
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setShort(BigDecimal _short);
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setLong(BigDecimal _long);
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setGlobal(BigDecimal global);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("short"), BigDecimal.class, getShort(), this);
			processor.processBasic(path.newSubPath("long"), BigDecimal.class, getLong(), this);
			processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
		}
		

		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitUtilizationPosition  ***********************/
	class CreditLimitUtilizationPositionImpl implements CreditLimitUtilizationPosition {
		private final BigDecimal _short;
		private final BigDecimal _long;
		private final BigDecimal global;
		
		protected CreditLimitUtilizationPositionImpl(CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder) {
			this._short = builder.getShort();
			this._long = builder.getLong();
			this.global = builder.getGlobal();
		}
		
		@Override
		@RosettaAttribute("short")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("short")
		public BigDecimal getShort() {
			return _short;
		}
		
		@Override
		@RosettaAttribute("long")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("long")
		public BigDecimal getLong() {
			return _long;
		}
		
		@Override
		@RosettaAttribute("global")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		public CreditLimitUtilizationPosition build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder toBuilder() {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder) {
			ofNullable(getShort()).ifPresent(builder::setShort);
			ofNullable(getLong()).ifPresent(builder::setLong);
			ofNullable(getGlobal()).ifPresent(builder::setGlobal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilizationPosition _that = getType().cast(o);
		
			if (!Objects.equals(_short, _that.getShort())) return false;
			if (!Objects.equals(_long, _that.getLong())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_short != null ? _short.hashCode() : 0);
			_result = 31 * _result + (_long != null ? _long.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationPosition {" +
				"short=" + this._short + ", " +
				"long=" + this._long + ", " +
				"global=" + this.global +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitUtilizationPosition  ***********************/
	class CreditLimitUtilizationPositionBuilderImpl implements CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder {
	
		protected BigDecimal _short;
		protected BigDecimal _long;
		protected BigDecimal global;
		
		@Override
		@RosettaAttribute("short")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("short")
		public BigDecimal getShort() {
			return _short;
		}
		
		@Override
		@RosettaAttribute("long")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("long")
		public BigDecimal getLong() {
			return _long;
		}
		
		@Override
		@RosettaAttribute("global")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@RosettaAttribute("short")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("short")
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setShort(BigDecimal __short) {
			this._short = __short == null ? null : __short;
			return this;
		}
		
		@RosettaAttribute("long")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("long")
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setLong(BigDecimal __long) {
			this._long = __long == null ? null : __long;
			return this;
		}
		
		@RosettaAttribute("global")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("global")
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setGlobal(BigDecimal _global) {
			this.global = _global == null ? null : _global;
			return this;
		}
		
		@Override
		public CreditLimitUtilizationPosition build() {
			return new CreditLimitUtilizationPosition.CreditLimitUtilizationPositionImpl(this);
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getShort()!=null) return true;
			if (getLong()!=null) return true;
			if (getGlobal()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder o = (CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder) other;
			
			
			merger.mergeBasic(getShort(), o.getShort(), this::setShort);
			merger.mergeBasic(getLong(), o.getLong(), this::setLong);
			merger.mergeBasic(getGlobal(), o.getGlobal(), this::setGlobal);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilizationPosition _that = getType().cast(o);
		
			if (!Objects.equals(_short, _that.getShort())) return false;
			if (!Objects.equals(_long, _that.getLong())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_short != null ? _short.hashCode() : 0);
			_result = 31 * _result + (_long != null ? _long.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationPositionBuilder {" +
				"short=" + this._short + ", " +
				"long=" + this._long + ", " +
				"global=" + this.global +
			'}';
		}
	}
}
