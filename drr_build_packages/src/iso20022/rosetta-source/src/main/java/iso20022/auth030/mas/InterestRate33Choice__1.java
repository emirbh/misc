package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.InterestRate33Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRate33Choice__1", builder=InterestRate33Choice__1.InterestRate33Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestRate33Choice__1", model="iso20022", builder=InterestRate33Choice__1.InterestRate33Choice__1BuilderImpl.class, version="${project.version}")
public interface InterestRate33Choice__1 extends RosettaModelObject {

	InterestRate33Choice__1Meta metaData = new InterestRate33Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	FixedRate10__1 getFxd();
	FloatingRate13__1 getFltg();

	/*********************** Build Methods  ***********************/
	InterestRate33Choice__1 build();
	
	InterestRate33Choice__1.InterestRate33Choice__1Builder toBuilder();
	
	static InterestRate33Choice__1.InterestRate33Choice__1Builder builder() {
		return new InterestRate33Choice__1.InterestRate33Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRate33Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRate33Choice__1> getType() {
		return InterestRate33Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxd"), processor, FixedRate10__1.class, getFxd());
		processRosetta(path.newSubPath("fltg"), processor, FloatingRate13__1.class, getFltg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRate33Choice__1Builder extends InterestRate33Choice__1, RosettaModelObjectBuilder {
		FixedRate10__1.FixedRate10__1Builder getOrCreateFxd();
		@Override
		FixedRate10__1.FixedRate10__1Builder getFxd();
		FloatingRate13__1.FloatingRate13__1Builder getOrCreateFltg();
		@Override
		FloatingRate13__1.FloatingRate13__1Builder getFltg();
		InterestRate33Choice__1.InterestRate33Choice__1Builder setFxd(FixedRate10__1 fxd);
		InterestRate33Choice__1.InterestRate33Choice__1Builder setFltg(FloatingRate13__1 fltg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxd"), processor, FixedRate10__1.FixedRate10__1Builder.class, getFxd());
			processRosetta(path.newSubPath("fltg"), processor, FloatingRate13__1.FloatingRate13__1Builder.class, getFltg());
		}
		

		InterestRate33Choice__1.InterestRate33Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of InterestRate33Choice__1  ***********************/
	class InterestRate33Choice__1Impl implements InterestRate33Choice__1 {
		private final FixedRate10__1 fxd;
		private final FloatingRate13__1 fltg;
		
		protected InterestRate33Choice__1Impl(InterestRate33Choice__1.InterestRate33Choice__1Builder builder) {
			this.fxd = ofNullable(builder.getFxd()).map(f->f.build()).orElse(null);
			this.fltg = ofNullable(builder.getFltg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxd")
		public FixedRate10__1 getFxd() {
			return fxd;
		}
		
		@Override
		@RosettaAttribute("fltg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fltg")
		public FloatingRate13__1 getFltg() {
			return fltg;
		}
		
		@Override
		public InterestRate33Choice__1 build() {
			return this;
		}
		
		@Override
		public InterestRate33Choice__1.InterestRate33Choice__1Builder toBuilder() {
			InterestRate33Choice__1.InterestRate33Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRate33Choice__1.InterestRate33Choice__1Builder builder) {
			ofNullable(getFxd()).ifPresent(builder::setFxd);
			ofNullable(getFltg()).ifPresent(builder::setFltg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRate33Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(fxd, _that.getFxd())) return false;
			if (!Objects.equals(fltg, _that.getFltg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxd != null ? fxd.hashCode() : 0);
			_result = 31 * _result + (fltg != null ? fltg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRate33Choice__1 {" +
				"fxd=" + this.fxd + ", " +
				"fltg=" + this.fltg +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRate33Choice__1  ***********************/
	class InterestRate33Choice__1BuilderImpl implements InterestRate33Choice__1.InterestRate33Choice__1Builder {
	
		protected FixedRate10__1.FixedRate10__1Builder fxd;
		protected FloatingRate13__1.FloatingRate13__1Builder fltg;
		
		@Override
		@RosettaAttribute("fxd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxd")
		public FixedRate10__1.FixedRate10__1Builder getFxd() {
			return fxd;
		}
		
		@Override
		public FixedRate10__1.FixedRate10__1Builder getOrCreateFxd() {
			FixedRate10__1.FixedRate10__1Builder result;
			if (fxd!=null) {
				result = fxd;
			}
			else {
				result = fxd = FixedRate10__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fltg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fltg")
		public FloatingRate13__1.FloatingRate13__1Builder getFltg() {
			return fltg;
		}
		
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder getOrCreateFltg() {
			FloatingRate13__1.FloatingRate13__1Builder result;
			if (fltg!=null) {
				result = fltg;
			}
			else {
				result = fltg = FloatingRate13__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fxd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxd")
		@Override
		public InterestRate33Choice__1.InterestRate33Choice__1Builder setFxd(FixedRate10__1 _fxd) {
			this.fxd = _fxd == null ? null : _fxd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fltg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fltg")
		@Override
		public InterestRate33Choice__1.InterestRate33Choice__1Builder setFltg(FloatingRate13__1 _fltg) {
			this.fltg = _fltg == null ? null : _fltg.toBuilder();
			return this;
		}
		
		@Override
		public InterestRate33Choice__1 build() {
			return new InterestRate33Choice__1.InterestRate33Choice__1Impl(this);
		}
		
		@Override
		public InterestRate33Choice__1.InterestRate33Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRate33Choice__1.InterestRate33Choice__1Builder prune() {
			if (fxd!=null && !fxd.prune().hasData()) fxd = null;
			if (fltg!=null && !fltg.prune().hasData()) fltg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxd()!=null && getFxd().hasData()) return true;
			if (getFltg()!=null && getFltg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRate33Choice__1.InterestRate33Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRate33Choice__1.InterestRate33Choice__1Builder o = (InterestRate33Choice__1.InterestRate33Choice__1Builder) other;
			
			merger.mergeRosetta(getFxd(), o.getFxd(), this::setFxd);
			merger.mergeRosetta(getFltg(), o.getFltg(), this::setFltg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRate33Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(fxd, _that.getFxd())) return false;
			if (!Objects.equals(fltg, _that.getFltg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxd != null ? fxd.hashCode() : 0);
			_result = 31 * _result + (fltg != null ? fltg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRate33Choice__1Builder {" +
				"fxd=" + this.fxd + ", " +
				"fltg=" + this.fltg +
			'}';
		}
	}
}
