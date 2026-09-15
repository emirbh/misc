package iso20022.auth108.hkma.dtcc;

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
import iso20022.auth108.hkma.dtcc.meta.SupplementaryData1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Additional information that can not be captured in the structured fields and/or any other specific block.
 * @version ${project.version}
 */
@RosettaDataType(value="SupplementaryData1__1", builder=SupplementaryData1__1.SupplementaryData1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SupplementaryData1__1", model="iso20022", builder=SupplementaryData1__1.SupplementaryData1__1BuilderImpl.class, version="${project.version}")
public interface SupplementaryData1__1 extends RosettaModelObject {

	SupplementaryData1__1Meta metaData = new SupplementaryData1__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Technical element wrapping the supplementary data.
	 */
	SupplementaryDataEnvelope1 getEnvlp();

	/*********************** Build Methods  ***********************/
	SupplementaryData1__1 build();
	
	SupplementaryData1__1.SupplementaryData1__1Builder toBuilder();
	
	static SupplementaryData1__1.SupplementaryData1__1Builder builder() {
		return new SupplementaryData1__1.SupplementaryData1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SupplementaryData1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SupplementaryData1__1> getType() {
		return SupplementaryData1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("envlp"), processor, SupplementaryDataEnvelope1.class, getEnvlp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SupplementaryData1__1Builder extends SupplementaryData1__1, RosettaModelObjectBuilder {
		SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder getOrCreateEnvlp();
		@Override
		SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder getEnvlp();
		SupplementaryData1__1.SupplementaryData1__1Builder setEnvlp(SupplementaryDataEnvelope1 envlp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("envlp"), processor, SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder.class, getEnvlp());
		}
		

		SupplementaryData1__1.SupplementaryData1__1Builder prune();
	}

	/*********************** Immutable Implementation of SupplementaryData1__1  ***********************/
	class SupplementaryData1__1Impl implements SupplementaryData1__1 {
		private final SupplementaryDataEnvelope1 envlp;
		
		protected SupplementaryData1__1Impl(SupplementaryData1__1.SupplementaryData1__1Builder builder) {
			this.envlp = ofNullable(builder.getEnvlp()).map(f->f.build()).orElse(null);
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
		public SupplementaryData1__1 build() {
			return this;
		}
		
		@Override
		public SupplementaryData1__1.SupplementaryData1__1Builder toBuilder() {
			SupplementaryData1__1.SupplementaryData1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SupplementaryData1__1.SupplementaryData1__1Builder builder) {
			ofNullable(getEnvlp()).ifPresent(builder::setEnvlp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupplementaryData1__1 _that = getType().cast(o);
		
			if (!Objects.equals(envlp, _that.getEnvlp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (envlp != null ? envlp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupplementaryData1__1 {" +
				"envlp=" + this.envlp +
			'}';
		}
	}

	/*********************** Builder Implementation of SupplementaryData1__1  ***********************/
	class SupplementaryData1__1BuilderImpl implements SupplementaryData1__1.SupplementaryData1__1Builder {
	
		protected SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder envlp;
		
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
		
		@RosettaAttribute("envlp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("envlp")
		@Override
		public SupplementaryData1__1.SupplementaryData1__1Builder setEnvlp(SupplementaryDataEnvelope1 _envlp) {
			this.envlp = _envlp == null ? null : _envlp.toBuilder();
			return this;
		}
		
		@Override
		public SupplementaryData1__1 build() {
			return new SupplementaryData1__1.SupplementaryData1__1Impl(this);
		}
		
		@Override
		public SupplementaryData1__1.SupplementaryData1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupplementaryData1__1.SupplementaryData1__1Builder prune() {
			if (envlp!=null && !envlp.prune().hasData()) envlp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEnvlp()!=null && getEnvlp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupplementaryData1__1.SupplementaryData1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SupplementaryData1__1.SupplementaryData1__1Builder o = (SupplementaryData1__1.SupplementaryData1__1Builder) other;
			
			merger.mergeRosetta(getEnvlp(), o.getEnvlp(), this::setEnvlp);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupplementaryData1__1 _that = getType().cast(o);
		
			if (!Objects.equals(envlp, _that.getEnvlp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (envlp != null ? envlp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupplementaryData1__1Builder {" +
				"envlp=" + this.envlp +
			'}';
		}
	}
}
