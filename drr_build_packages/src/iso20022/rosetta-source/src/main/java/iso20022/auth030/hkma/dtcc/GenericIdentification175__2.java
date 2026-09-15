package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.GenericIdentification175__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to an identification, for example party identification or account identification.
 * @version ${project.version}
 */
@RosettaDataType(value="GenericIdentification175__2", builder=GenericIdentification175__2.GenericIdentification175__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericIdentification175__2", model="iso20022", builder=GenericIdentification175__2.GenericIdentification175__2BuilderImpl.class, version="${project.version}")
public interface GenericIdentification175__2 extends RosettaModelObject {

	GenericIdentification175__2Meta metaData = new GenericIdentification175__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification assigned by an institution.
	 */
	String getId();
	/**
	 * Name of the identification scheme.
	 */
	HKTRPartyScheme getSchmeNm();

	/*********************** Build Methods  ***********************/
	GenericIdentification175__2 build();
	
	GenericIdentification175__2.GenericIdentification175__2Builder toBuilder();
	
	static GenericIdentification175__2.GenericIdentification175__2Builder builder() {
		return new GenericIdentification175__2.GenericIdentification175__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericIdentification175__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericIdentification175__2> getType() {
		return GenericIdentification175__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("schmeNm"), HKTRPartyScheme.class, getSchmeNm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericIdentification175__2Builder extends GenericIdentification175__2, RosettaModelObjectBuilder {
		GenericIdentification175__2.GenericIdentification175__2Builder setId(String id);
		GenericIdentification175__2.GenericIdentification175__2Builder setSchmeNm(HKTRPartyScheme schmeNm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("schmeNm"), HKTRPartyScheme.class, getSchmeNm(), this);
		}
		

		GenericIdentification175__2.GenericIdentification175__2Builder prune();
	}

	/*********************** Immutable Implementation of GenericIdentification175__2  ***********************/
	class GenericIdentification175__2Impl implements GenericIdentification175__2 {
		private final String id;
		private final HKTRPartyScheme schmeNm;
		
		protected GenericIdentification175__2Impl(GenericIdentification175__2.GenericIdentification175__2Builder builder) {
			this.id = builder.getId();
			this.schmeNm = builder.getSchmeNm();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("schmeNm")
		public HKTRPartyScheme getSchmeNm() {
			return schmeNm;
		}
		
		@Override
		public GenericIdentification175__2 build() {
			return this;
		}
		
		@Override
		public GenericIdentification175__2.GenericIdentification175__2Builder toBuilder() {
			GenericIdentification175__2.GenericIdentification175__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericIdentification175__2.GenericIdentification175__2Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSchmeNm()).ifPresent(builder::setSchmeNm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175__2 {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericIdentification175__2  ***********************/
	class GenericIdentification175__2BuilderImpl implements GenericIdentification175__2.GenericIdentification175__2Builder {
	
		protected String id;
		protected HKTRPartyScheme schmeNm;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("schmeNm")
		public HKTRPartyScheme getSchmeNm() {
			return schmeNm;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public GenericIdentification175__2.GenericIdentification175__2Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("schmeNm")
		@Override
		public GenericIdentification175__2.GenericIdentification175__2Builder setSchmeNm(HKTRPartyScheme _schmeNm) {
			this.schmeNm = _schmeNm == null ? null : _schmeNm;
			return this;
		}
		
		@Override
		public GenericIdentification175__2 build() {
			return new GenericIdentification175__2.GenericIdentification175__2Impl(this);
		}
		
		@Override
		public GenericIdentification175__2.GenericIdentification175__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__2.GenericIdentification175__2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getSchmeNm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__2.GenericIdentification175__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericIdentification175__2.GenericIdentification175__2Builder o = (GenericIdentification175__2.GenericIdentification175__2Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getSchmeNm(), o.getSchmeNm(), this::setSchmeNm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175__2Builder {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}
}
