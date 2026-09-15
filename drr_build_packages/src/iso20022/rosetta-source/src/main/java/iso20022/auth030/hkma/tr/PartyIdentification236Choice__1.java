package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.PartyIdentification236Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyIdentification236Choice__1", builder=PartyIdentification236Choice__1.PartyIdentification236Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PartyIdentification236Choice__1", model="iso20022", builder=PartyIdentification236Choice__1.PartyIdentification236Choice__1BuilderImpl.class, version="${project.version}")
public interface PartyIdentification236Choice__1 extends RosettaModelObject {

	PartyIdentification236Choice__1Meta metaData = new PartyIdentification236Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party is a legal person.
	 */
	OrganisationIdentification15Choice__3 getLgl();
	/**
	 * Party is a natural person.
	 */
	NaturalPersonIdentification2__1 getNtrl();

	/*********************** Build Methods  ***********************/
	PartyIdentification236Choice__1 build();
	
	PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder toBuilder();
	
	static PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder builder() {
		return new PartyIdentification236Choice__1.PartyIdentification236Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyIdentification236Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyIdentification236Choice__1> getType() {
		return PartyIdentification236Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lgl"), processor, OrganisationIdentification15Choice__3.class, getLgl());
		processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification2__1.class, getNtrl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdentification236Choice__1Builder extends PartyIdentification236Choice__1, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateLgl();
		@Override
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getLgl();
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getOrCreateNtrl();
		@Override
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getNtrl();
		PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder setLgl(OrganisationIdentification15Choice__3 lgl);
		PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder setNtrl(NaturalPersonIdentification2__1 ntrl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lgl"), processor, OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder.class, getLgl());
			processRosetta(path.newSubPath("ntrl"), processor, NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder.class, getNtrl());
		}
		

		PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of PartyIdentification236Choice__1  ***********************/
	class PartyIdentification236Choice__1Impl implements PartyIdentification236Choice__1 {
		private final OrganisationIdentification15Choice__3 lgl;
		private final NaturalPersonIdentification2__1 ntrl;
		
		protected PartyIdentification236Choice__1Impl(PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder builder) {
			this.lgl = ofNullable(builder.getLgl()).map(f->f.build()).orElse(null);
			this.ntrl = ofNullable(builder.getNtrl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public OrganisationIdentification15Choice__3 getLgl() {
			return lgl;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification2__1 getNtrl() {
			return ntrl;
		}
		
		@Override
		public PartyIdentification236Choice__1 build() {
			return this;
		}
		
		@Override
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder toBuilder() {
			PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder builder) {
			ofNullable(getLgl()).ifPresent(builder::setLgl);
			ofNullable(getNtrl()).ifPresent(builder::setNtrl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification236Choice__1 _that = getType().cast(o);
		
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
			return "PartyIdentification236Choice__1 {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyIdentification236Choice__1  ***********************/
	class PartyIdentification236Choice__1BuilderImpl implements PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder {
	
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder lgl;
		protected NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder ntrl;
		
		@Override
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lgl")
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getLgl() {
			return lgl;
		}
		
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateLgl() {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder result;
			if (lgl!=null) {
				result = lgl;
			}
			else {
				result = lgl = OrganisationIdentification15Choice__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrl")
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getNtrl() {
			return ntrl;
		}
		
		@Override
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getOrCreateNtrl() {
			NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder result;
			if (ntrl!=null) {
				result = ntrl;
			}
			else {
				result = ntrl = NaturalPersonIdentification2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("lgl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lgl")
		@Override
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder setLgl(OrganisationIdentification15Choice__3 _lgl) {
			this.lgl = _lgl == null ? null : _lgl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntrl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntrl")
		@Override
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder setNtrl(NaturalPersonIdentification2__1 _ntrl) {
			this.ntrl = _ntrl == null ? null : _ntrl.toBuilder();
			return this;
		}
		
		@Override
		public PartyIdentification236Choice__1 build() {
			return new PartyIdentification236Choice__1.PartyIdentification236Choice__1Impl(this);
		}
		
		@Override
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder prune() {
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
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder o = (PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder) other;
			
			merger.mergeRosetta(getLgl(), o.getLgl(), this::setLgl);
			merger.mergeRosetta(getNtrl(), o.getNtrl(), this::setNtrl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyIdentification236Choice__1 _that = getType().cast(o);
		
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
			return "PartyIdentification236Choice__1Builder {" +
				"lgl=" + this.lgl + ", " +
				"ntrl=" + this.ntrl +
			'}';
		}
	}
}
