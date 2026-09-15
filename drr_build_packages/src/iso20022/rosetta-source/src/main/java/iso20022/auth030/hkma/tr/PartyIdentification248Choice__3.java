package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.PartyIdentification248Choice__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyIdentification248Choice__3", builder=PartyIdentification248Choice__3.PartyIdentification248Choice__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PartyIdentification248Choice__3", model="iso20022", builder=PartyIdentification248Choice__3.PartyIdentification248Choice__3BuilderImpl.class, version="${project.version}")
public interface PartyIdentification248Choice__3 extends RosettaModelObject {

	PartyIdentification248Choice__3Meta metaData = new PartyIdentification248Choice__3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party is a legal person.
	 */
	LegalPersonIdentification1__3 getLgl();

	/*********************** Build Methods  ***********************/
	PartyIdentification248Choice__3 build();
	
	PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder toBuilder();
	
	static PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder builder() {
		return new PartyIdentification248Choice__3.PartyIdentification248Choice__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyIdentification248Choice__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyIdentification248Choice__3> getType() {
		return PartyIdentification248Choice__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__3.class, getLgl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdentification248Choice__3Builder extends PartyIdentification248Choice__3, RosettaModelObjectBuilder {
		LegalPersonIdentification1__3.LegalPersonIdentification1__3Builder getOrCreateLgl();
		@Override
		LegalPersonIdentification1__3.LegalPersonIdentification1__3Builder getLgl();
		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder setLgl(LegalPersonIdentification1__3 lgl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__3.LegalPersonIdentification1__3Builder.class, getLgl());
		}
		

		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder prune();
	}

	/*********************** Immutable Implementation of PartyIdentification248Choice__3  ***********************/
	class PartyIdentification248Choice__3Impl implements PartyIdentification248Choice__3 {
		private final LegalPersonIdentification1__3 lgl;
		
		protected PartyIdentification248Choice__3Impl(PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder builder) {
			this.lgl = ofNullable(builder.getLgl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__3 getLgl() {
			return lgl;
		}
		
		@Override
		public PartyIdentification248Choice__3 build() {
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder toBuilder() {
			PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder builder) {
			ofNullable(getLgl()).ifPresent(builder::setLgl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__3 _that = getType().cast(o);
		
			if (!Objects.equals(lgl, _that.getLgl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lgl != null ? lgl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyIdentification248Choice__3 {" +
				"lgl=" + this.lgl +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyIdentification248Choice__3  ***********************/
	class PartyIdentification248Choice__3BuilderImpl implements PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder {
	
		protected LegalPersonIdentification1__3.LegalPersonIdentification1__3Builder lgl;
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__3.LegalPersonIdentification1__3Builder getLgl() {
			return lgl;
		}
		
		@Override
		public LegalPersonIdentification1__3.LegalPersonIdentification1__3Builder getOrCreateLgl() {
			LegalPersonIdentification1__3.LegalPersonIdentification1__3Builder result;
			if (lgl!=null) {
				result = lgl;
			}
			else {
				result = lgl = LegalPersonIdentification1__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lgl")
		@Override
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder setLgl(LegalPersonIdentification1__3 _lgl) {
			this.lgl = _lgl == null ? null : _lgl.toBuilder();
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__3 build() {
			return new PartyIdentification248Choice__3.PartyIdentification248Choice__3Impl(this);
		}
		
		@Override
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder prune() {
			if (lgl!=null && !lgl.prune().hasData()) lgl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLgl()!=null && getLgl().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder o = (PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder) other;
			
			merger.mergeRosetta(getLgl(), o.getLgl(), this::setLgl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__3 _that = getType().cast(o);
		
			if (!Objects.equals(lgl, _that.getLgl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lgl != null ? lgl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyIdentification248Choice__3Builder {" +
				"lgl=" + this.lgl +
			'}';
		}
	}
}
