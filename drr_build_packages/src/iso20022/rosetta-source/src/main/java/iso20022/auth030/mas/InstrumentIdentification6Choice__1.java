package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.InstrumentIdentification6Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InstrumentIdentification6Choice__1", builder=InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InstrumentIdentification6Choice__1", model="iso20022", builder=InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1BuilderImpl.class, version="${project.version}")
public interface InstrumentIdentification6Choice__1 extends RosettaModelObject {

	InstrumentIdentification6Choice__1Meta metaData = new InstrumentIdentification6Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	String getIsin();
	GenericIdentification184 getOthrId();

	/*********************** Build Methods  ***********************/
	InstrumentIdentification6Choice__1 build();
	
	InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder toBuilder();
	
	static InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder() {
		return new InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentIdentification6Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InstrumentIdentification6Choice__1> getType() {
		return InstrumentIdentification6Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
		processRosetta(path.newSubPath("othrId"), processor, GenericIdentification184.class, getOthrId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentIdentification6Choice__1Builder extends InstrumentIdentification6Choice__1, RosettaModelObjectBuilder {
		GenericIdentification184.GenericIdentification184Builder getOrCreateOthrId();
		@Override
		GenericIdentification184.GenericIdentification184Builder getOthrId();
		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder setIsin(String isin);
		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder setOthrId(GenericIdentification184 othrId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
			processRosetta(path.newSubPath("othrId"), processor, GenericIdentification184.GenericIdentification184Builder.class, getOthrId());
		}
		

		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of InstrumentIdentification6Choice__1  ***********************/
	class InstrumentIdentification6Choice__1Impl implements InstrumentIdentification6Choice__1 {
		private final String isin;
		private final GenericIdentification184 othrId;
		
		protected InstrumentIdentification6Choice__1Impl(InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder) {
			this.isin = builder.getIsin();
			this.othrId = ofNullable(builder.getOthrId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("othrId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othrId")
		public GenericIdentification184 getOthrId() {
			return othrId;
		}
		
		@Override
		public InstrumentIdentification6Choice__1 build() {
			return this;
		}
		
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder toBuilder() {
			InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder) {
			ofNullable(getIsin()).ifPresent(builder::setIsin);
			ofNullable(getOthrId()).ifPresent(builder::setOthrId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentIdentification6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(othrId, _that.getOthrId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (othrId != null ? othrId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentIdentification6Choice__1 {" +
				"isin=" + this.isin + ", " +
				"othrId=" + this.othrId +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentIdentification6Choice__1  ***********************/
	class InstrumentIdentification6Choice__1BuilderImpl implements InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder {
	
		protected String isin;
		protected GenericIdentification184.GenericIdentification184Builder othrId;
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("othrId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othrId")
		public GenericIdentification184.GenericIdentification184Builder getOthrId() {
			return othrId;
		}
		
		@Override
		public GenericIdentification184.GenericIdentification184Builder getOrCreateOthrId() {
			GenericIdentification184.GenericIdentification184Builder result;
			if (othrId!=null) {
				result = othrId;
			}
			else {
				result = othrId = GenericIdentification184.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isin")
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder setIsin(String _isin) {
			this.isin = _isin == null ? null : _isin;
			return this;
		}
		
		@RosettaAttribute("othrId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othrId")
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder setOthrId(GenericIdentification184 _othrId) {
			this.othrId = _othrId == null ? null : _othrId.toBuilder();
			return this;
		}
		
		@Override
		public InstrumentIdentification6Choice__1 build() {
			return new InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Impl(this);
		}
		
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder prune() {
			if (othrId!=null && !othrId.prune().hasData()) othrId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsin()!=null) return true;
			if (getOthrId()!=null && getOthrId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder o = (InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder) other;
			
			merger.mergeRosetta(getOthrId(), o.getOthrId(), this::setOthrId);
			
			merger.mergeBasic(getIsin(), o.getIsin(), this::setIsin);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentIdentification6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(othrId, _that.getOthrId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (othrId != null ? othrId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentIdentification6Choice__1Builder {" +
				"isin=" + this.isin + ", " +
				"othrId=" + this.othrId +
			'}';
		}
	}
}
