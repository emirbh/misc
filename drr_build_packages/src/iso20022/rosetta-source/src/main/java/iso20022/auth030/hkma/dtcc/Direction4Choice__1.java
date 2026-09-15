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
import iso20022.auth030.hkma.dtcc.meta.Direction4Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between elements indicating the direction of the derivative transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="Direction4Choice__1", builder=Direction4Choice__1.Direction4Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Direction4Choice__1", model="iso20022", builder=Direction4Choice__1.Direction4Choice__1BuilderImpl.class, version="${project.version}")
public interface Direction4Choice__1 extends RosettaModelObject {

	Direction4Choice__1Meta metaData = new Direction4Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies whether the reporting counterparty is the payer (Taker) or the receiver (Maker).  Usage: DirectionOfTheFirstLeg should be used for most swaps and swap-like contracts including interest rate swaps, credit total return swaps, and equity swaps (except for credit default swaps, variance, volatility, and correlation swaps) as well as for the foreign exchange swaps, forwards and non-deliverable forwards.
	 */
	Direction2__1 getDrctn();
	/**
	 * Identifies whether the reporting counterparty is the buyer or the seller as determined at the time of transaction.
	 */
	OptionParty1Code getCtrPtySd();

	/*********************** Build Methods  ***********************/
	Direction4Choice__1 build();
	
	Direction4Choice__1.Direction4Choice__1Builder toBuilder();
	
	static Direction4Choice__1.Direction4Choice__1Builder builder() {
		return new Direction4Choice__1.Direction4Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Direction4Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Direction4Choice__1> getType() {
		return Direction4Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("drctn"), processor, Direction2__1.class, getDrctn());
		processor.processBasic(path.newSubPath("ctrPtySd"), OptionParty1Code.class, getCtrPtySd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Direction4Choice__1Builder extends Direction4Choice__1, RosettaModelObjectBuilder {
		Direction2__1.Direction2__1Builder getOrCreateDrctn();
		@Override
		Direction2__1.Direction2__1Builder getDrctn();
		Direction4Choice__1.Direction4Choice__1Builder setDrctn(Direction2__1 drctn);
		Direction4Choice__1.Direction4Choice__1Builder setCtrPtySd(OptionParty1Code ctrPtySd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("drctn"), processor, Direction2__1.Direction2__1Builder.class, getDrctn());
			processor.processBasic(path.newSubPath("ctrPtySd"), OptionParty1Code.class, getCtrPtySd(), this);
		}
		

		Direction4Choice__1.Direction4Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of Direction4Choice__1  ***********************/
	class Direction4Choice__1Impl implements Direction4Choice__1 {
		private final Direction2__1 drctn;
		private final OptionParty1Code ctrPtySd;
		
		protected Direction4Choice__1Impl(Direction4Choice__1.Direction4Choice__1Builder builder) {
			this.drctn = ofNullable(builder.getDrctn()).map(f->f.build()).orElse(null);
			this.ctrPtySd = builder.getCtrPtySd();
		}
		
		@Override
		@RosettaAttribute("drctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctn")
		public Direction2__1 getDrctn() {
			return drctn;
		}
		
		@Override
		@RosettaAttribute("ctrPtySd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtySd")
		public OptionParty1Code getCtrPtySd() {
			return ctrPtySd;
		}
		
		@Override
		public Direction4Choice__1 build() {
			return this;
		}
		
		@Override
		public Direction4Choice__1.Direction4Choice__1Builder toBuilder() {
			Direction4Choice__1.Direction4Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Direction4Choice__1.Direction4Choice__1Builder builder) {
			ofNullable(getDrctn()).ifPresent(builder::setDrctn);
			ofNullable(getCtrPtySd()).ifPresent(builder::setCtrPtySd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(drctn, _that.getDrctn())) return false;
			if (!Objects.equals(ctrPtySd, _that.getCtrPtySd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drctn != null ? drctn.hashCode() : 0);
			_result = 31 * _result + (ctrPtySd != null ? ctrPtySd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Direction4Choice__1 {" +
				"drctn=" + this.drctn + ", " +
				"ctrPtySd=" + this.ctrPtySd +
			'}';
		}
	}

	/*********************** Builder Implementation of Direction4Choice__1  ***********************/
	class Direction4Choice__1BuilderImpl implements Direction4Choice__1.Direction4Choice__1Builder {
	
		protected Direction2__1.Direction2__1Builder drctn;
		protected OptionParty1Code ctrPtySd;
		
		@Override
		@RosettaAttribute("drctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctn")
		public Direction2__1.Direction2__1Builder getDrctn() {
			return drctn;
		}
		
		@Override
		public Direction2__1.Direction2__1Builder getOrCreateDrctn() {
			Direction2__1.Direction2__1Builder result;
			if (drctn!=null) {
				result = drctn;
			}
			else {
				result = drctn = Direction2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ctrPtySd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtySd")
		public OptionParty1Code getCtrPtySd() {
			return ctrPtySd;
		}
		
		@RosettaAttribute("drctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drctn")
		@Override
		public Direction4Choice__1.Direction4Choice__1Builder setDrctn(Direction2__1 _drctn) {
			this.drctn = _drctn == null ? null : _drctn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ctrPtySd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrPtySd")
		@Override
		public Direction4Choice__1.Direction4Choice__1Builder setCtrPtySd(OptionParty1Code _ctrPtySd) {
			this.ctrPtySd = _ctrPtySd == null ? null : _ctrPtySd;
			return this;
		}
		
		@Override
		public Direction4Choice__1 build() {
			return new Direction4Choice__1.Direction4Choice__1Impl(this);
		}
		
		@Override
		public Direction4Choice__1.Direction4Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Direction4Choice__1.Direction4Choice__1Builder prune() {
			if (drctn!=null && !drctn.prune().hasData()) drctn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDrctn()!=null && getDrctn().hasData()) return true;
			if (getCtrPtySd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Direction4Choice__1.Direction4Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Direction4Choice__1.Direction4Choice__1Builder o = (Direction4Choice__1.Direction4Choice__1Builder) other;
			
			merger.mergeRosetta(getDrctn(), o.getDrctn(), this::setDrctn);
			
			merger.mergeBasic(getCtrPtySd(), o.getCtrPtySd(), this::setCtrPtySd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(drctn, _that.getDrctn())) return false;
			if (!Objects.equals(ctrPtySd, _that.getCtrPtySd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drctn != null ? drctn.hashCode() : 0);
			_result = 31 * _result + (ctrPtySd != null ? ctrPtySd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Direction4Choice__1Builder {" +
				"drctn=" + this.drctn + ", " +
				"ctrPtySd=" + this.ctrPtySd +
			'}';
		}
	}
}
