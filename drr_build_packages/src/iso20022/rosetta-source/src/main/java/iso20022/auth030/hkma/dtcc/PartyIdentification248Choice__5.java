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
import iso20022.auth030.hkma.dtcc.meta.PartyIdentification248Choice__5Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyIdentification248Choice__5", builder=PartyIdentification248Choice__5.PartyIdentification248Choice__5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PartyIdentification248Choice__5", model="iso20022", builder=PartyIdentification248Choice__5.PartyIdentification248Choice__5BuilderImpl.class, version="${project.version}")
public interface PartyIdentification248Choice__5 extends RosettaModelObject {

	PartyIdentification248Choice__5Meta metaData = new PartyIdentification248Choice__5Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party is a legal person.
	 */
	LegalPersonIdentification1__5 getLgl();
	/**
	 * Party is a natural person.
	 */
	NaturalPersonIdentification3__2 getNtrl();

	/*********************** Build Methods  ***********************/
	PartyIdentification248Choice__5 build();
	
	PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder toBuilder();
	
	static PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder builder() {
		return new PartyIdentification248Choice__5.PartyIdentification248Choice__5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyIdentification248Choice__5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyIdentification248Choice__5> getType() {
		return PartyIdentification248Choice__5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__5.class, getLgl());
		processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3__2.class, getNtrl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdentification248Choice__5Builder extends PartyIdentification248Choice__5, RosettaModelObjectBuilder {
		LegalPersonIdentification1__5.LegalPersonIdentification1__5Builder getOrCreateLgl();
		@Override
		LegalPersonIdentification1__5.LegalPersonIdentification1__5Builder getLgl();
		NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder getOrCreateNtrl();
		@Override
		NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder getNtrl();
		PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder setLgl(LegalPersonIdentification1__5 lgl);
		PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder setNtrl(NaturalPersonIdentification3__2 ntrl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__5.LegalPersonIdentification1__5Builder.class, getLgl());
			processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder.class, getNtrl());
		}
		

		PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder prune();
	}

	/*********************** Immutable Implementation of PartyIdentification248Choice__5  ***********************/
	class PartyIdentification248Choice__5Impl implements PartyIdentification248Choice__5 {
		private final LegalPersonIdentification1__5 lgl;
		private final NaturalPersonIdentification3__2 ntrl;
		
		protected PartyIdentification248Choice__5Impl(PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder builder) {
			this.lgl = ofNullable(builder.getLgl()).map(f->f.build()).orElse(null);
			this.ntrl = ofNullable(builder.getNtrl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__5 getLgl() {
			return lgl;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3__2 getNtrl() {
			return ntrl;
		}
		
		@Override
		public PartyIdentification248Choice__5 build() {
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder toBuilder() {
			PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder builder) {
			ofNullable(getLgl()).ifPresent(builder::setLgl);
			ofNullable(getNtrl()).ifPresent(builder::setNtrl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__5 _that = getType().cast(o);
		
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
			return "PartyIdentification248Choice__5 {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyIdentification248Choice__5  ***********************/
	class PartyIdentification248Choice__5BuilderImpl implements PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder {
	
		protected LegalPersonIdentification1__5.LegalPersonIdentification1__5Builder lgl;
		protected NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder ntrl;
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__5.LegalPersonIdentification1__5Builder getLgl() {
			return lgl;
		}
		
		@Override
		public LegalPersonIdentification1__5.LegalPersonIdentification1__5Builder getOrCreateLgl() {
			LegalPersonIdentification1__5.LegalPersonIdentification1__5Builder result;
			if (lgl!=null) {
				result = lgl;
			}
			else {
				result = lgl = LegalPersonIdentification1__5.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder getNtrl() {
			return ntrl;
		}
		
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder getOrCreateNtrl() {
			NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder result;
			if (ntrl!=null) {
				result = ntrl;
			}
			else {
				result = ntrl = NaturalPersonIdentification3__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lgl")
		@Override
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder setLgl(LegalPersonIdentification1__5 _lgl) {
			this.lgl = _lgl == null ? null : _lgl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntrl")
		@Override
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder setNtrl(NaturalPersonIdentification3__2 _ntrl) {
			this.ntrl = _ntrl == null ? null : _ntrl.toBuilder();
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__5 build() {
			return new PartyIdentification248Choice__5.PartyIdentification248Choice__5Impl(this);
		}
		
		@Override
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder prune() {
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
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder o = (PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder) other;
			
			merger.mergeRosetta(getLgl(), o.getLgl(), this::setLgl);
			merger.mergeRosetta(getNtrl(), o.getNtrl(), this::setNtrl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__5 _that = getType().cast(o);
		
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
			return "PartyIdentification248Choice__5Builder {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}
}
