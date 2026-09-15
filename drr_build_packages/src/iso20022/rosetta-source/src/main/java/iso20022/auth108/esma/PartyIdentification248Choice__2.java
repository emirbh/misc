package iso20022.auth108.esma;

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
import iso20022.auth108.esma.meta.PartyIdentification248Choice__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyIdentification248Choice__2", builder=PartyIdentification248Choice__2.PartyIdentification248Choice__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PartyIdentification248Choice__2", model="iso20022", builder=PartyIdentification248Choice__2.PartyIdentification248Choice__2BuilderImpl.class, version="${project.version}")
public interface PartyIdentification248Choice__2 extends RosettaModelObject {

	PartyIdentification248Choice__2Meta metaData = new PartyIdentification248Choice__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party is a legal person.
	 */
	LegalPersonIdentification1__1 getLgl();
	/**
	 * Party is a natural person.
	 */
	NaturalPersonIdentification3__1 getNtrl();

	/*********************** Build Methods  ***********************/
	PartyIdentification248Choice__2 build();
	
	PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder toBuilder();
	
	static PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder builder() {
		return new PartyIdentification248Choice__2.PartyIdentification248Choice__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyIdentification248Choice__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyIdentification248Choice__2> getType() {
		return PartyIdentification248Choice__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__1.class, getLgl());
		processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3__1.class, getNtrl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdentification248Choice__2Builder extends PartyIdentification248Choice__2, RosettaModelObjectBuilder {
		LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder getOrCreateLgl();
		@Override
		LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder getLgl();
		NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder getOrCreateNtrl();
		@Override
		NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder getNtrl();
		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder setLgl(LegalPersonIdentification1__1 lgl);
		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder setNtrl(NaturalPersonIdentification3__1 ntrl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder.class, getLgl());
			processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder.class, getNtrl());
		}
		

		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder prune();
	}

	/*********************** Immutable Implementation of PartyIdentification248Choice__2  ***********************/
	class PartyIdentification248Choice__2Impl implements PartyIdentification248Choice__2 {
		private final LegalPersonIdentification1__1 lgl;
		private final NaturalPersonIdentification3__1 ntrl;
		
		protected PartyIdentification248Choice__2Impl(PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder builder) {
			this.lgl = ofNullable(builder.getLgl()).map(f->f.build()).orElse(null);
			this.ntrl = ofNullable(builder.getNtrl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__1 getLgl() {
			return lgl;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3__1 getNtrl() {
			return ntrl;
		}
		
		@Override
		public PartyIdentification248Choice__2 build() {
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder toBuilder() {
			PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder builder) {
			ofNullable(getLgl()).ifPresent(builder::setLgl);
			ofNullable(getNtrl()).ifPresent(builder::setNtrl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(lgl, _that.getLgl())) return false;
			if (!Objects.equals(ntrl, _that.getNtrl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lgl != null ? lgl.hashCode() : 0);
			_result = 31 * _result + (ntrl != null ? ntrl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyIdentification248Choice__2 {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyIdentification248Choice__2  ***********************/
	class PartyIdentification248Choice__2BuilderImpl implements PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder {
	
		protected LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder lgl;
		protected NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder ntrl;
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder getLgl() {
			return lgl;
		}
		
		@Override
		public LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder getOrCreateLgl() {
			LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder result;
			if (lgl!=null) {
				result = lgl;
			}
			else {
				result = lgl = LegalPersonIdentification1__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder getNtrl() {
			return ntrl;
		}
		
		@Override
		public NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder getOrCreateNtrl() {
			NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder result;
			if (ntrl!=null) {
				result = ntrl;
			}
			else {
				result = ntrl = NaturalPersonIdentification3__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lgl")
		@Override
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder setLgl(LegalPersonIdentification1__1 _lgl) {
			this.lgl = _lgl == null ? null : _lgl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntrl")
		@Override
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder setNtrl(NaturalPersonIdentification3__1 _ntrl) {
			this.ntrl = _ntrl == null ? null : _ntrl.toBuilder();
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__2 build() {
			return new PartyIdentification248Choice__2.PartyIdentification248Choice__2Impl(this);
		}
		
		@Override
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder prune() {
			if (lgl!=null && !lgl.prune().hasData()) lgl = null;
			if (ntrl!=null && !ntrl.prune().hasData()) ntrl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLgl()!=null && getLgl().hasData()) return true;
			if (getNtrl()!=null && getNtrl().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder o = (PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder) other;
			
			merger.mergeRosetta(getLgl(), o.getLgl(), this::setLgl);
			merger.mergeRosetta(getNtrl(), o.getNtrl(), this::setNtrl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(lgl, _that.getLgl())) return false;
			if (!Objects.equals(ntrl, _that.getNtrl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lgl != null ? lgl.hashCode() : 0);
			_result = 31 * _result + (ntrl != null ? ntrl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyIdentification248Choice__2Builder {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}
}
