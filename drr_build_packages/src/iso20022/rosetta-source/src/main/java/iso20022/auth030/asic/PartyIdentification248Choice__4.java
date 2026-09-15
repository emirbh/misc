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
import iso20022.auth030.asic.meta.PartyIdentification248Choice__4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PartyIdentification248Choice__4", builder=PartyIdentification248Choice__4.PartyIdentification248Choice__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PartyIdentification248Choice__4", model="iso20022", builder=PartyIdentification248Choice__4.PartyIdentification248Choice__4BuilderImpl.class, version="${project.version}")
public interface PartyIdentification248Choice__4 extends RosettaModelObject {

	PartyIdentification248Choice__4Meta metaData = new PartyIdentification248Choice__4Meta();

	/*********************** Getter Methods  ***********************/
	LegalPersonIdentification1__4 getLgl();
	NaturalPersonIdentification3__3 getNtrl();

	/*********************** Build Methods  ***********************/
	PartyIdentification248Choice__4 build();
	
	PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder toBuilder();
	
	static PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder builder() {
		return new PartyIdentification248Choice__4.PartyIdentification248Choice__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyIdentification248Choice__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyIdentification248Choice__4> getType() {
		return PartyIdentification248Choice__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__4.class, getLgl());
		processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3__3.class, getNtrl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdentification248Choice__4Builder extends PartyIdentification248Choice__4, RosettaModelObjectBuilder {
		LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder getOrCreateLgl();
		@Override
		LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder getLgl();
		NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder getOrCreateNtrl();
		@Override
		NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder getNtrl();
		PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder setLgl(LegalPersonIdentification1__4 lgl);
		PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder setNtrl(NaturalPersonIdentification3__3 ntrl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder.class, getLgl());
			processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder.class, getNtrl());
		}
		

		PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder prune();
	}

	/*********************** Immutable Implementation of PartyIdentification248Choice__4  ***********************/
	class PartyIdentification248Choice__4Impl implements PartyIdentification248Choice__4 {
		private final LegalPersonIdentification1__4 lgl;
		private final NaturalPersonIdentification3__3 ntrl;
		
		protected PartyIdentification248Choice__4Impl(PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder builder) {
			this.lgl = ofNullable(builder.getLgl()).map(f->f.build()).orElse(null);
			this.ntrl = ofNullable(builder.getNtrl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__4 getLgl() {
			return lgl;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3__3 getNtrl() {
			return ntrl;
		}
		
		@Override
		public PartyIdentification248Choice__4 build() {
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder toBuilder() {
			PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder builder) {
			ofNullable(getLgl()).ifPresent(builder::setLgl);
			ofNullable(getNtrl()).ifPresent(builder::setNtrl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__4 _that = getType().cast(o);
		
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
			return "PartyIdentification248Choice__4 {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyIdentification248Choice__4  ***********************/
	class PartyIdentification248Choice__4BuilderImpl implements PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder {
	
		protected LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder lgl;
		protected NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder ntrl;
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder getLgl() {
			return lgl;
		}
		
		@Override
		public LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder getOrCreateLgl() {
			LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder result;
			if (lgl!=null) {
				result = lgl;
			}
			else {
				result = lgl = LegalPersonIdentification1__4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder getNtrl() {
			return ntrl;
		}
		
		@Override
		public NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder getOrCreateNtrl() {
			NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder result;
			if (ntrl!=null) {
				result = ntrl;
			}
			else {
				result = ntrl = NaturalPersonIdentification3__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lgl")
		@Override
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder setLgl(LegalPersonIdentification1__4 _lgl) {
			this.lgl = _lgl == null ? null : _lgl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntrl")
		@Override
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder setNtrl(NaturalPersonIdentification3__3 _ntrl) {
			this.ntrl = _ntrl == null ? null : _ntrl.toBuilder();
			return this;
		}
		
		@Override
		public PartyIdentification248Choice__4 build() {
			return new PartyIdentification248Choice__4.PartyIdentification248Choice__4Impl(this);
		}
		
		@Override
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder prune() {
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
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder o = (PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder) other;
			
			merger.mergeRosetta(getLgl(), o.getLgl(), this::setLgl);
			merger.mergeRosetta(getNtrl(), o.getNtrl(), this::setNtrl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice__4 _that = getType().cast(o);
		
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
			return "PartyIdentification248Choice__4Builder {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}
}
