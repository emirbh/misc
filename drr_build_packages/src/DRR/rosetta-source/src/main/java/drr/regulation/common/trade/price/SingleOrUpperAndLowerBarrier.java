package drr.regulation.common.trade.price;

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
import drr.regulation.common.trade.price.meta.SingleOrUpperAndLowerBarrierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="SingleOrUpperAndLowerBarrier", builder=SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilderImpl.class, version="7.7.0")
@RuneDataType(value="SingleOrUpperAndLowerBarrier", model="drr", builder=SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilderImpl.class, version="7.7.0")
public interface SingleOrUpperAndLowerBarrier extends RosettaModelObject {

	SingleOrUpperAndLowerBarrierMeta metaData = new SingleOrUpperAndLowerBarrierMeta();

	/*********************** Getter Methods  ***********************/
	BarrierPrice get_single();
	BarrierPrice getUpper();
	BarrierPrice getLower();

	/*********************** Build Methods  ***********************/
	SingleOrUpperAndLowerBarrier build();
	
	SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder toBuilder();
	
	static SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder builder() {
		return new SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SingleOrUpperAndLowerBarrier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SingleOrUpperAndLowerBarrier> getType() {
		return SingleOrUpperAndLowerBarrier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("_single"), processor, BarrierPrice.class, get_single());
		processRosetta(path.newSubPath("upper"), processor, BarrierPrice.class, getUpper());
		processRosetta(path.newSubPath("lower"), processor, BarrierPrice.class, getLower());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SingleOrUpperAndLowerBarrierBuilder extends SingleOrUpperAndLowerBarrier, RosettaModelObjectBuilder {
		BarrierPrice.BarrierPriceBuilder getOrCreate_single();
		@Override
		BarrierPrice.BarrierPriceBuilder get_single();
		BarrierPrice.BarrierPriceBuilder getOrCreateUpper();
		@Override
		BarrierPrice.BarrierPriceBuilder getUpper();
		BarrierPrice.BarrierPriceBuilder getOrCreateLower();
		@Override
		BarrierPrice.BarrierPriceBuilder getLower();
		SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder set_single(BarrierPrice _single);
		SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder setUpper(BarrierPrice upper);
		SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder setLower(BarrierPrice lower);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("_single"), processor, BarrierPrice.BarrierPriceBuilder.class, get_single());
			processRosetta(path.newSubPath("upper"), processor, BarrierPrice.BarrierPriceBuilder.class, getUpper());
			processRosetta(path.newSubPath("lower"), processor, BarrierPrice.BarrierPriceBuilder.class, getLower());
		}
		

		SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of SingleOrUpperAndLowerBarrier  ***********************/
	class SingleOrUpperAndLowerBarrierImpl implements SingleOrUpperAndLowerBarrier {
		private final BarrierPrice _single;
		private final BarrierPrice upper;
		private final BarrierPrice lower;
		
		protected SingleOrUpperAndLowerBarrierImpl(SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder builder) {
			this._single = ofNullable(builder.get_single()).map(f->f.build()).orElse(null);
			this.upper = ofNullable(builder.getUpper()).map(f->f.build()).orElse(null);
			this.lower = ofNullable(builder.getLower()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("_single")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("_single")
		public BarrierPrice get_single() {
			return _single;
		}
		
		@Override
		@RosettaAttribute("upper")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upper")
		public BarrierPrice getUpper() {
			return upper;
		}
		
		@Override
		@RosettaAttribute("lower")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lower")
		public BarrierPrice getLower() {
			return lower;
		}
		
		@Override
		public SingleOrUpperAndLowerBarrier build() {
			return this;
		}
		
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder toBuilder() {
			SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder builder) {
			ofNullable(get_single()).ifPresent(builder::set_single);
			ofNullable(getUpper()).ifPresent(builder::setUpper);
			ofNullable(getLower()).ifPresent(builder::setLower);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleOrUpperAndLowerBarrier _that = getType().cast(o);
		
			if (!Objects.equals(_single, _that.get_single())) return false;
			if (!Objects.equals(upper, _that.getUpper())) return false;
			if (!Objects.equals(lower, _that.getLower())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_single != null ? _single.hashCode() : 0);
			_result = 31 * _result + (upper != null ? upper.hashCode() : 0);
			_result = 31 * _result + (lower != null ? lower.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleOrUpperAndLowerBarrier {" +
				"_single=" + this._single + ", " +
				"upper=" + this.upper + ", " +
				"lower=" + this.lower +
			'}';
		}
	}

	/*********************** Builder Implementation of SingleOrUpperAndLowerBarrier  ***********************/
	class SingleOrUpperAndLowerBarrierBuilderImpl implements SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder {
	
		protected BarrierPrice.BarrierPriceBuilder _single;
		protected BarrierPrice.BarrierPriceBuilder upper;
		protected BarrierPrice.BarrierPriceBuilder lower;
		
		@Override
		@RosettaAttribute("_single")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("_single")
		public BarrierPrice.BarrierPriceBuilder get_single() {
			return _single;
		}
		
		@Override
		public BarrierPrice.BarrierPriceBuilder getOrCreate_single() {
			BarrierPrice.BarrierPriceBuilder result;
			if (_single!=null) {
				result = _single;
			}
			else {
				result = _single = BarrierPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upper")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upper")
		public BarrierPrice.BarrierPriceBuilder getUpper() {
			return upper;
		}
		
		@Override
		public BarrierPrice.BarrierPriceBuilder getOrCreateUpper() {
			BarrierPrice.BarrierPriceBuilder result;
			if (upper!=null) {
				result = upper;
			}
			else {
				result = upper = BarrierPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lower")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lower")
		public BarrierPrice.BarrierPriceBuilder getLower() {
			return lower;
		}
		
		@Override
		public BarrierPrice.BarrierPriceBuilder getOrCreateLower() {
			BarrierPrice.BarrierPriceBuilder result;
			if (lower!=null) {
				result = lower;
			}
			else {
				result = lower = BarrierPrice.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("_single")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("_single")
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder set_single(BarrierPrice __single) {
			this._single = __single == null ? null : __single.toBuilder();
			return this;
		}
		
		@RosettaAttribute("upper")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upper")
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder setUpper(BarrierPrice _upper) {
			this.upper = _upper == null ? null : _upper.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lower")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lower")
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder setLower(BarrierPrice _lower) {
			this.lower = _lower == null ? null : _lower.toBuilder();
			return this;
		}
		
		@Override
		public SingleOrUpperAndLowerBarrier build() {
			return new SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierImpl(this);
		}
		
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder prune() {
			if (_single!=null && !_single.prune().hasData()) _single = null;
			if (upper!=null && !upper.prune().hasData()) upper = null;
			if (lower!=null && !lower.prune().hasData()) lower = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (get_single()!=null && get_single().hasData()) return true;
			if (getUpper()!=null && getUpper().hasData()) return true;
			if (getLower()!=null && getLower().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder o = (SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder) other;
			
			merger.mergeRosetta(get_single(), o.get_single(), this::set_single);
			merger.mergeRosetta(getUpper(), o.getUpper(), this::setUpper);
			merger.mergeRosetta(getLower(), o.getLower(), this::setLower);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleOrUpperAndLowerBarrier _that = getType().cast(o);
		
			if (!Objects.equals(_single, _that.get_single())) return false;
			if (!Objects.equals(upper, _that.getUpper())) return false;
			if (!Objects.equals(lower, _that.getLower())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_single != null ? _single.hashCode() : 0);
			_result = 31 * _result + (upper != null ? upper.hashCode() : 0);
			_result = 31 * _result + (lower != null ? lower.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleOrUpperAndLowerBarrierBuilder {" +
				"_single=" + this._single + ", " +
				"upper=" + this.upper + ", " +
				"lower=" + this.lower +
			'}';
		}
	}
}
