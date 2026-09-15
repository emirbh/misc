package fpml.consolidated.mktenv;

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
import fpml.consolidated.mktenv.meta.ZeroRateCurveMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A curve used to model a set of zero-coupon interest rates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A curve used to model a set of zero-coupon interest rates.
 *
 */
@RosettaDataType(value="ZeroRateCurve", builder=ZeroRateCurve.ZeroRateCurveBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ZeroRateCurve", model="fpml", builder=ZeroRateCurve.ZeroRateCurveBuilderImpl.class, version="2.1.1")
public interface ZeroRateCurve extends RosettaModelObject {

	ZeroRateCurveMeta metaData = new ZeroRateCurveMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which the rates are compounded (e.g. continuously compounded).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which the rates are compounded (e.g. continuously compounded).
	 *
	 */
	CompoundingFrequency getCompoundingFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The curve of zero-coupon values.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The curve of zero-coupon values.
	 *
	 */
	TermCurve getRateCurve();

	/*********************** Build Methods  ***********************/
	ZeroRateCurve build();
	
	ZeroRateCurve.ZeroRateCurveBuilder toBuilder();
	
	static ZeroRateCurve.ZeroRateCurveBuilder builder() {
		return new ZeroRateCurve.ZeroRateCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ZeroRateCurve> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ZeroRateCurve> getType() {
		return ZeroRateCurve.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("compoundingFrequency"), processor, CompoundingFrequency.class, getCompoundingFrequency());
		processRosetta(path.newSubPath("rateCurve"), processor, TermCurve.class, getRateCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ZeroRateCurveBuilder extends ZeroRateCurve, RosettaModelObjectBuilder {
		CompoundingFrequency.CompoundingFrequencyBuilder getOrCreateCompoundingFrequency();
		@Override
		CompoundingFrequency.CompoundingFrequencyBuilder getCompoundingFrequency();
		TermCurve.TermCurveBuilder getOrCreateRateCurve();
		@Override
		TermCurve.TermCurveBuilder getRateCurve();
		ZeroRateCurve.ZeroRateCurveBuilder setCompoundingFrequency(CompoundingFrequency compoundingFrequency);
		ZeroRateCurve.ZeroRateCurveBuilder setRateCurve(TermCurve rateCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("compoundingFrequency"), processor, CompoundingFrequency.CompoundingFrequencyBuilder.class, getCompoundingFrequency());
			processRosetta(path.newSubPath("rateCurve"), processor, TermCurve.TermCurveBuilder.class, getRateCurve());
		}
		

		ZeroRateCurve.ZeroRateCurveBuilder prune();
	}

	/*********************** Immutable Implementation of ZeroRateCurve  ***********************/
	class ZeroRateCurveImpl implements ZeroRateCurve {
		private final CompoundingFrequency compoundingFrequency;
		private final TermCurve rateCurve;
		
		protected ZeroRateCurveImpl(ZeroRateCurve.ZeroRateCurveBuilder builder) {
			this.compoundingFrequency = ofNullable(builder.getCompoundingFrequency()).map(f->f.build()).orElse(null);
			this.rateCurve = ofNullable(builder.getRateCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compoundingFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingFrequency")
		public CompoundingFrequency getCompoundingFrequency() {
			return compoundingFrequency;
		}
		
		@Override
		@RosettaAttribute("rateCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateCurve")
		public TermCurve getRateCurve() {
			return rateCurve;
		}
		
		@Override
		public ZeroRateCurve build() {
			return this;
		}
		
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder toBuilder() {
			ZeroRateCurve.ZeroRateCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ZeroRateCurve.ZeroRateCurveBuilder builder) {
			ofNullable(getCompoundingFrequency()).ifPresent(builder::setCompoundingFrequency);
			ofNullable(getRateCurve()).ifPresent(builder::setRateCurve);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ZeroRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(compoundingFrequency, _that.getCompoundingFrequency())) return false;
			if (!Objects.equals(rateCurve, _that.getRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingFrequency != null ? compoundingFrequency.hashCode() : 0);
			_result = 31 * _result + (rateCurve != null ? rateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ZeroRateCurve {" +
				"compoundingFrequency=" + this.compoundingFrequency + ", " +
				"rateCurve=" + this.rateCurve +
			'}';
		}
	}

	/*********************** Builder Implementation of ZeroRateCurve  ***********************/
	class ZeroRateCurveBuilderImpl implements ZeroRateCurve.ZeroRateCurveBuilder {
	
		protected CompoundingFrequency.CompoundingFrequencyBuilder compoundingFrequency;
		protected TermCurve.TermCurveBuilder rateCurve;
		
		@Override
		@RosettaAttribute("compoundingFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingFrequency")
		public CompoundingFrequency.CompoundingFrequencyBuilder getCompoundingFrequency() {
			return compoundingFrequency;
		}
		
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder getOrCreateCompoundingFrequency() {
			CompoundingFrequency.CompoundingFrequencyBuilder result;
			if (compoundingFrequency!=null) {
				result = compoundingFrequency;
			}
			else {
				result = compoundingFrequency = CompoundingFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateCurve")
		public TermCurve.TermCurveBuilder getRateCurve() {
			return rateCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateRateCurve() {
			TermCurve.TermCurveBuilder result;
			if (rateCurve!=null) {
				result = rateCurve;
			}
			else {
				result = rateCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("compoundingFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compoundingFrequency")
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder setCompoundingFrequency(CompoundingFrequency _compoundingFrequency) {
			this.compoundingFrequency = _compoundingFrequency == null ? null : _compoundingFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateCurve")
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder setRateCurve(TermCurve _rateCurve) {
			this.rateCurve = _rateCurve == null ? null : _rateCurve.toBuilder();
			return this;
		}
		
		@Override
		public ZeroRateCurve build() {
			return new ZeroRateCurve.ZeroRateCurveImpl(this);
		}
		
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder prune() {
			if (compoundingFrequency!=null && !compoundingFrequency.prune().hasData()) compoundingFrequency = null;
			if (rateCurve!=null && !rateCurve.prune().hasData()) rateCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompoundingFrequency()!=null && getCompoundingFrequency().hasData()) return true;
			if (getRateCurve()!=null && getRateCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ZeroRateCurve.ZeroRateCurveBuilder o = (ZeroRateCurve.ZeroRateCurveBuilder) other;
			
			merger.mergeRosetta(getCompoundingFrequency(), o.getCompoundingFrequency(), this::setCompoundingFrequency);
			merger.mergeRosetta(getRateCurve(), o.getRateCurve(), this::setRateCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ZeroRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(compoundingFrequency, _that.getCompoundingFrequency())) return false;
			if (!Objects.equals(rateCurve, _that.getRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingFrequency != null ? compoundingFrequency.hashCode() : 0);
			_result = 31 * _result + (rateCurve != null ? rateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ZeroRateCurveBuilder {" +
				"compoundingFrequency=" + this.compoundingFrequency + ", " +
				"rateCurve=" + this.rateCurve +
			'}';
		}
	}
}
