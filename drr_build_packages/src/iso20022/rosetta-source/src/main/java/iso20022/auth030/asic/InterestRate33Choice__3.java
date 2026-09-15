package iso20022.auth030.asic;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.asic.meta.InterestRate33Choice__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRate33Choice__3", builder=InterestRate33Choice__3.InterestRate33Choice__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestRate33Choice__3", model="iso20022", builder=InterestRate33Choice__3.InterestRate33Choice__3BuilderImpl.class, version="${project.version}")
public interface InterestRate33Choice__3 extends RosettaModelObject {

	InterestRate33Choice__3Meta metaData = new InterestRate33Choice__3Meta();

	/*********************** Getter Methods  ***********************/
	FloatingRate13__3 getFltg();

	/*********************** Build Methods  ***********************/
	InterestRate33Choice__3 build();
	
	InterestRate33Choice__3.InterestRate33Choice__3Builder toBuilder();
	
	static InterestRate33Choice__3.InterestRate33Choice__3Builder builder() {
		return new InterestRate33Choice__3.InterestRate33Choice__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRate33Choice__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRate33Choice__3> getType() {
		return InterestRate33Choice__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fltg"), processor, FloatingRate13__3.class, getFltg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRate33Choice__3Builder extends InterestRate33Choice__3, RosettaModelObjectBuilder {
		FloatingRate13__3.FloatingRate13__3Builder getOrCreateFltg();
		@Override
		FloatingRate13__3.FloatingRate13__3Builder getFltg();
		InterestRate33Choice__3.InterestRate33Choice__3Builder setFltg(FloatingRate13__3 fltg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fltg"), processor, FloatingRate13__3.FloatingRate13__3Builder.class, getFltg());
		}
		

		InterestRate33Choice__3.InterestRate33Choice__3Builder prune();
	}

	/*********************** Immutable Implementation of InterestRate33Choice__3  ***********************/
	class InterestRate33Choice__3Impl implements InterestRate33Choice__3 {
		private final FloatingRate13__3 fltg;
		
		protected InterestRate33Choice__3Impl(InterestRate33Choice__3.InterestRate33Choice__3Builder builder) {
			this.fltg = ofNullable(builder.getFltg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fltg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fltg")
		public FloatingRate13__3 getFltg() {
			return fltg;
		}
		
		@Override
		public InterestRate33Choice__3 build() {
			return this;
		}
		
		@Override
		public InterestRate33Choice__3.InterestRate33Choice__3Builder toBuilder() {
			InterestRate33Choice__3.InterestRate33Choice__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRate33Choice__3.InterestRate33Choice__3Builder builder) {
			ofNullable(getFltg()).ifPresent(builder::setFltg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRate33Choice__3 _that = getType().cast(o);
		
			if (!Objects.equals(fltg, _that.getFltg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fltg != null ? fltg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRate33Choice__3 {" +
				"fltg=" + this.fltg +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRate33Choice__3  ***********************/
	class InterestRate33Choice__3BuilderImpl implements InterestRate33Choice__3.InterestRate33Choice__3Builder {
	
		protected FloatingRate13__3.FloatingRate13__3Builder fltg;
		
		@Override
		@RosettaAttribute("fltg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fltg")
		public FloatingRate13__3.FloatingRate13__3Builder getFltg() {
			return fltg;
		}
		
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder getOrCreateFltg() {
			FloatingRate13__3.FloatingRate13__3Builder result;
			if (fltg!=null) {
				result = fltg;
			}
			else {
				result = fltg = FloatingRate13__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fltg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fltg")
		@Override
		public InterestRate33Choice__3.InterestRate33Choice__3Builder setFltg(FloatingRate13__3 _fltg) {
			this.fltg = _fltg == null ? null : _fltg.toBuilder();
			return this;
		}
		
		@Override
		public InterestRate33Choice__3 build() {
			return new InterestRate33Choice__3.InterestRate33Choice__3Impl(this);
		}
		
		@Override
		public InterestRate33Choice__3.InterestRate33Choice__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRate33Choice__3.InterestRate33Choice__3Builder prune() {
			if (fltg!=null && !fltg.prune().hasData()) fltg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFltg()!=null && getFltg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRate33Choice__3.InterestRate33Choice__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRate33Choice__3.InterestRate33Choice__3Builder o = (InterestRate33Choice__3.InterestRate33Choice__3Builder) other;
			
			merger.mergeRosetta(getFltg(), o.getFltg(), this::setFltg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRate33Choice__3 _that = getType().cast(o);
		
			if (!Objects.equals(fltg, _that.getFltg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fltg != null ? fltg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRate33Choice__3Builder {" +
				"fltg=" + this.fltg +
			'}';
		}
	}
}
