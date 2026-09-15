package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.FloatingRate13__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRate13__3", builder=FloatingRate13__3.FloatingRate13__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FloatingRate13__3", model="iso20022", builder=FloatingRate13__3.FloatingRate13__3BuilderImpl.class, version="${project.version}")
public interface FloatingRate13__3 extends RosettaModelObject {

	FloatingRate13__3Meta metaData = new FloatingRate13__3Meta();

	/*********************** Getter Methods  ***********************/
	ResetDateAndValue1__1 getNxtFltgRst();

	/*********************** Build Methods  ***********************/
	FloatingRate13__3 build();
	
	FloatingRate13__3.FloatingRate13__3Builder toBuilder();
	
	static FloatingRate13__3.FloatingRate13__3Builder builder() {
		return new FloatingRate13__3.FloatingRate13__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRate13__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRate13__3> getType() {
		return FloatingRate13__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("nxtFltgRst"), processor, ResetDateAndValue1__1.class, getNxtFltgRst());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRate13__3Builder extends FloatingRate13__3, RosettaModelObjectBuilder {
		ResetDateAndValue1__1.ResetDateAndValue1__1Builder getOrCreateNxtFltgRst();
		@Override
		ResetDateAndValue1__1.ResetDateAndValue1__1Builder getNxtFltgRst();
		FloatingRate13__3.FloatingRate13__3Builder setNxtFltgRst(ResetDateAndValue1__1 nxtFltgRst);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("nxtFltgRst"), processor, ResetDateAndValue1__1.ResetDateAndValue1__1Builder.class, getNxtFltgRst());
		}
		

		FloatingRate13__3.FloatingRate13__3Builder prune();
	}

	/*********************** Immutable Implementation of FloatingRate13__3  ***********************/
	class FloatingRate13__3Impl implements FloatingRate13__3 {
		private final ResetDateAndValue1__1 nxtFltgRst;
		
		protected FloatingRate13__3Impl(FloatingRate13__3.FloatingRate13__3Builder builder) {
			this.nxtFltgRst = ofNullable(builder.getNxtFltgRst()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nxtFltgRst")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nxtFltgRst")
		public ResetDateAndValue1__1 getNxtFltgRst() {
			return nxtFltgRst;
		}
		
		@Override
		public FloatingRate13__3 build() {
			return this;
		}
		
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder toBuilder() {
			FloatingRate13__3.FloatingRate13__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRate13__3.FloatingRate13__3Builder builder) {
			ofNullable(getNxtFltgRst()).ifPresent(builder::setNxtFltgRst);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__3 _that = getType().cast(o);
		
			if (!Objects.equals(nxtFltgRst, _that.getNxtFltgRst())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nxtFltgRst != null ? nxtFltgRst.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__3 {" +
				"nxtFltgRst=" + this.nxtFltgRst +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRate13__3  ***********************/
	class FloatingRate13__3BuilderImpl implements FloatingRate13__3.FloatingRate13__3Builder {
	
		protected ResetDateAndValue1__1.ResetDateAndValue1__1Builder nxtFltgRst;
		
		@Override
		@RosettaAttribute("nxtFltgRst")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nxtFltgRst")
		public ResetDateAndValue1__1.ResetDateAndValue1__1Builder getNxtFltgRst() {
			return nxtFltgRst;
		}
		
		@Override
		public ResetDateAndValue1__1.ResetDateAndValue1__1Builder getOrCreateNxtFltgRst() {
			ResetDateAndValue1__1.ResetDateAndValue1__1Builder result;
			if (nxtFltgRst!=null) {
				result = nxtFltgRst;
			}
			else {
				result = nxtFltgRst = ResetDateAndValue1__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nxtFltgRst")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nxtFltgRst")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setNxtFltgRst(ResetDateAndValue1__1 _nxtFltgRst) {
			this.nxtFltgRst = _nxtFltgRst == null ? null : _nxtFltgRst.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRate13__3 build() {
			return new FloatingRate13__3.FloatingRate13__3Impl(this);
		}
		
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder prune() {
			if (nxtFltgRst!=null && !nxtFltgRst.prune().hasData()) nxtFltgRst = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNxtFltgRst()!=null && getNxtFltgRst().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRate13__3.FloatingRate13__3Builder o = (FloatingRate13__3.FloatingRate13__3Builder) other;
			
			merger.mergeRosetta(getNxtFltgRst(), o.getNxtFltgRst(), this::setNxtFltgRst);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__3 _that = getType().cast(o);
		
			if (!Objects.equals(nxtFltgRst, _that.getNxtFltgRst())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nxtFltgRst != null ? nxtFltgRst.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__3Builder {" +
				"nxtFltgRst=" + this.nxtFltgRst +
			'}';
		}
	}
}
