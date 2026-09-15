package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.PartyIdentification248ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyIdentification248Choice", builder=PartyIdentification248Choice.PartyIdentification248ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="PartyIdentification248Choice", model="iso20022", builder=PartyIdentification248Choice.PartyIdentification248ChoiceBuilderImpl.class, version="${project.version}")
public interface PartyIdentification248Choice extends RosettaModelObject {

	PartyIdentification248ChoiceMeta metaData = new PartyIdentification248ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party is a legal person.
	 */
	LegalPersonIdentification1 getLgl();
	/**
	 * Party is a natural person.
	 */
	NaturalPersonIdentification3 getNtrl();

	/*********************** Build Methods  ***********************/
	PartyIdentification248Choice build();
	
	PartyIdentification248Choice.PartyIdentification248ChoiceBuilder toBuilder();
	
	static PartyIdentification248Choice.PartyIdentification248ChoiceBuilder builder() {
		return new PartyIdentification248Choice.PartyIdentification248ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyIdentification248Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyIdentification248Choice> getType() {
		return PartyIdentification248Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1.class, getLgl());
		processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3.class, getNtrl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdentification248ChoiceBuilder extends PartyIdentification248Choice, RosettaModelObjectBuilder {
		LegalPersonIdentification1.LegalPersonIdentification1Builder getOrCreateLgl();
		@Override
		LegalPersonIdentification1.LegalPersonIdentification1Builder getLgl();
		NaturalPersonIdentification3.NaturalPersonIdentification3Builder getOrCreateNtrl();
		@Override
		NaturalPersonIdentification3.NaturalPersonIdentification3Builder getNtrl();
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder setLgl(LegalPersonIdentification1 lgl);
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder setNtrl(NaturalPersonIdentification3 ntrl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lgl"), processor, LegalPersonIdentification1.LegalPersonIdentification1Builder.class, getLgl());
			processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification3.NaturalPersonIdentification3Builder.class, getNtrl());
		}
		

		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of PartyIdentification248Choice  ***********************/
	class PartyIdentification248ChoiceImpl implements PartyIdentification248Choice {
		private final LegalPersonIdentification1 lgl;
		private final NaturalPersonIdentification3 ntrl;
		
		protected PartyIdentification248ChoiceImpl(PartyIdentification248Choice.PartyIdentification248ChoiceBuilder builder) {
			this.lgl = ofNullable(builder.getLgl()).map(f->f.build()).orElse(null);
			this.ntrl = ofNullable(builder.getNtrl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1 getLgl() {
			return lgl;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3 getNtrl() {
			return ntrl;
		}
		
		@Override
		public PartyIdentification248Choice build() {
			return this;
		}
		
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder toBuilder() {
			PartyIdentification248Choice.PartyIdentification248ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyIdentification248Choice.PartyIdentification248ChoiceBuilder builder) {
			ofNullable(getLgl()).ifPresent(builder::setLgl);
			ofNullable(getNtrl()).ifPresent(builder::setNtrl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice _that = getType().cast(o);
		
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
			return "PartyIdentification248Choice {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyIdentification248Choice  ***********************/
	class PartyIdentification248ChoiceBuilderImpl implements PartyIdentification248Choice.PartyIdentification248ChoiceBuilder {
	
		protected LegalPersonIdentification1.LegalPersonIdentification1Builder lgl;
		protected NaturalPersonIdentification3.NaturalPersonIdentification3Builder ntrl;
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public LegalPersonIdentification1.LegalPersonIdentification1Builder getLgl() {
			return lgl;
		}
		
		@Override
		public LegalPersonIdentification1.LegalPersonIdentification1Builder getOrCreateLgl() {
			LegalPersonIdentification1.LegalPersonIdentification1Builder result;
			if (lgl!=null) {
				result = lgl;
			}
			else {
				result = lgl = LegalPersonIdentification1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification3.NaturalPersonIdentification3Builder getNtrl() {
			return ntrl;
		}
		
		@Override
		public NaturalPersonIdentification3.NaturalPersonIdentification3Builder getOrCreateNtrl() {
			NaturalPersonIdentification3.NaturalPersonIdentification3Builder result;
			if (ntrl!=null) {
				result = ntrl;
			}
			else {
				result = ntrl = NaturalPersonIdentification3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lgl")
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder setLgl(LegalPersonIdentification1 _lgl) {
			this.lgl = _lgl == null ? null : _lgl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntrl")
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder setNtrl(NaturalPersonIdentification3 _ntrl) {
			this.ntrl = _ntrl == null ? null : _ntrl.toBuilder();
			return this;
		}
		
		@Override
		public PartyIdentification248Choice build() {
			return new PartyIdentification248Choice.PartyIdentification248ChoiceImpl(this);
		}
		
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder prune() {
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
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyIdentification248Choice.PartyIdentification248ChoiceBuilder o = (PartyIdentification248Choice.PartyIdentification248ChoiceBuilder) other;
			
			merger.mergeRosetta(getLgl(), o.getLgl(), this::setLgl);
			merger.mergeRosetta(getNtrl(), o.getNtrl(), this::setNtrl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification248Choice _that = getType().cast(o);
		
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
			return "PartyIdentification248ChoiceBuilder {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}
}
