package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.SupplementaryData1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Additional information that can not be captured in the structured fields and/or any other specific block.
 * @version ${project.version}
 */
@RosettaDataType(value="SupplementaryData1", builder=SupplementaryData1.SupplementaryData1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SupplementaryData1", model="iso20022", builder=SupplementaryData1.SupplementaryData1BuilderImpl.class, version="${project.version}")
public interface SupplementaryData1 extends RosettaModelObject {

	SupplementaryData1Meta metaData = new SupplementaryData1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unambiguous reference to the location where the supplementary data must be inserted in the message instance.  In the case of XML, this is expressed by a valid XPath.
	 */
	String getPlcAndNm();
	/**
	 * Technical element wrapping the supplementary data.
	 */
	SupplementaryDataEnvelope1 getEnvlp();

	/*********************** Build Methods  ***********************/
	SupplementaryData1 build();
	
	SupplementaryData1.SupplementaryData1Builder toBuilder();
	
	static SupplementaryData1.SupplementaryData1Builder builder() {
		return new SupplementaryData1.SupplementaryData1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SupplementaryData1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SupplementaryData1> getType() {
		return SupplementaryData1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("plcAndNm"), String.class, getPlcAndNm(), this);
		processRosetta(path.newSubPath("envlp"), processor, SupplementaryDataEnvelope1.class, getEnvlp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SupplementaryData1Builder extends SupplementaryData1, RosettaModelObjectBuilder {
		SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder getOrCreateEnvlp();
		@Override
		SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder getEnvlp();
		SupplementaryData1.SupplementaryData1Builder setPlcAndNm(String plcAndNm);
		SupplementaryData1.SupplementaryData1Builder setEnvlp(SupplementaryDataEnvelope1 envlp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("plcAndNm"), String.class, getPlcAndNm(), this);
			processRosetta(path.newSubPath("envlp"), processor, SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder.class, getEnvlp());
		}
		

		SupplementaryData1.SupplementaryData1Builder prune();
	}

	/*********************** Immutable Implementation of SupplementaryData1  ***********************/
	class SupplementaryData1Impl implements SupplementaryData1 {
		private final String plcAndNm;
		private final SupplementaryDataEnvelope1 envlp;
		
		protected SupplementaryData1Impl(SupplementaryData1.SupplementaryData1Builder builder) {
			this.plcAndNm = builder.getPlcAndNm();
			this.envlp = ofNullable(builder.getEnvlp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("plcAndNm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plcAndNm")
		public String getPlcAndNm() {
			return plcAndNm;
		}
		
		@Override
		@RosettaAttribute("envlp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("envlp")
		public SupplementaryDataEnvelope1 getEnvlp() {
			return envlp;
		}
		
		@Override
		public SupplementaryData1 build() {
			return this;
		}
		
		@Override
		public SupplementaryData1.SupplementaryData1Builder toBuilder() {
			SupplementaryData1.SupplementaryData1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SupplementaryData1.SupplementaryData1Builder builder) {
			ofNullable(getPlcAndNm()).ifPresent(builder::setPlcAndNm);
			ofNullable(getEnvlp()).ifPresent(builder::setEnvlp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupplementaryData1 _that = getType().cast(o);
		
			if (!Objects.equals(plcAndNm, _that.getPlcAndNm())) return false;
			if (!Objects.equals(envlp, _that.getEnvlp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (plcAndNm != null ? plcAndNm.hashCode() : 0);
			_result = 31 * _result + (envlp != null ? envlp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupplementaryData1 {" +
				"plcAndNm=" + this.plcAndNm + ", " +
				"envlp=" + this.envlp +
			'}';
		}
	}

	/*********************** Builder Implementation of SupplementaryData1  ***********************/
	class SupplementaryData1BuilderImpl implements SupplementaryData1.SupplementaryData1Builder {
	
		protected String plcAndNm;
		protected SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder envlp;
		
		@Override
		@RosettaAttribute("plcAndNm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plcAndNm")
		public String getPlcAndNm() {
			return plcAndNm;
		}
		
		@Override
		@RosettaAttribute("envlp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("envlp")
		public SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder getEnvlp() {
			return envlp;
		}
		
		@Override
		public SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder getOrCreateEnvlp() {
			SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder result;
			if (envlp!=null) {
				result = envlp;
			}
			else {
				result = envlp = SupplementaryDataEnvelope1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("plcAndNm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("plcAndNm")
		@Override
		public SupplementaryData1.SupplementaryData1Builder setPlcAndNm(String _plcAndNm) {
			this.plcAndNm = _plcAndNm == null ? null : _plcAndNm;
			return this;
		}
		
		@RosettaAttribute("envlp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("envlp")
		@Override
		public SupplementaryData1.SupplementaryData1Builder setEnvlp(SupplementaryDataEnvelope1 _envlp) {
			this.envlp = _envlp == null ? null : _envlp.toBuilder();
			return this;
		}
		
		@Override
		public SupplementaryData1 build() {
			return new SupplementaryData1.SupplementaryData1Impl(this);
		}
		
		@Override
		public SupplementaryData1.SupplementaryData1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupplementaryData1.SupplementaryData1Builder prune() {
			if (envlp!=null && !envlp.prune().hasData()) envlp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPlcAndNm()!=null) return true;
			if (getEnvlp()!=null && getEnvlp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupplementaryData1.SupplementaryData1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SupplementaryData1.SupplementaryData1Builder o = (SupplementaryData1.SupplementaryData1Builder) other;
			
			merger.mergeRosetta(getEnvlp(), o.getEnvlp(), this::setEnvlp);
			
			merger.mergeBasic(getPlcAndNm(), o.getPlcAndNm(), this::setPlcAndNm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupplementaryData1 _that = getType().cast(o);
		
			if (!Objects.equals(plcAndNm, _that.getPlcAndNm())) return false;
			if (!Objects.equals(envlp, _that.getEnvlp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (plcAndNm != null ? plcAndNm.hashCode() : 0);
			_result = 31 * _result + (envlp != null ? envlp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupplementaryData1Builder {" +
				"plcAndNm=" + this.plcAndNm + ", " +
				"envlp=" + this.envlp +
			'}';
		}
	}
}
