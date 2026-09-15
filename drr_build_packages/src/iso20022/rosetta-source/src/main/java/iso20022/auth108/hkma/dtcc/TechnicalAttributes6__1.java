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
import iso20022.auth108.hkma.dtcc.meta.TechnicalAttributes6__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies technical attributes of the message.
 * @version ${project.version}
 */
@RosettaDataType(value="TechnicalAttributes6__1", builder=TechnicalAttributes6__1.TechnicalAttributes6__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TechnicalAttributes6__1", model="iso20022", builder=TechnicalAttributes6__1.TechnicalAttributes6__1BuilderImpl.class, version="${project.version}")
public interface TechnicalAttributes6__1 extends RosettaModelObject {

	TechnicalAttributes6__1Meta metaData = new TechnicalAttributes6__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique identifier of a record in a message used as part of error management and status advice message.
	 */
	String getTechRcrdId();

	/*********************** Build Methods  ***********************/
	TechnicalAttributes6__1 build();
	
	TechnicalAttributes6__1.TechnicalAttributes6__1Builder toBuilder();
	
	static TechnicalAttributes6__1.TechnicalAttributes6__1Builder builder() {
		return new TechnicalAttributes6__1.TechnicalAttributes6__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TechnicalAttributes6__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TechnicalAttributes6__1> getType() {
		return TechnicalAttributes6__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("techRcrdId"), String.class, getTechRcrdId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TechnicalAttributes6__1Builder extends TechnicalAttributes6__1, RosettaModelObjectBuilder {
		TechnicalAttributes6__1.TechnicalAttributes6__1Builder setTechRcrdId(String techRcrdId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("techRcrdId"), String.class, getTechRcrdId(), this);
		}
		

		TechnicalAttributes6__1.TechnicalAttributes6__1Builder prune();
	}

	/*********************** Immutable Implementation of TechnicalAttributes6__1  ***********************/
	class TechnicalAttributes6__1Impl implements TechnicalAttributes6__1 {
		private final String techRcrdId;
		
		protected TechnicalAttributes6__1Impl(TechnicalAttributes6__1.TechnicalAttributes6__1Builder builder) {
			this.techRcrdId = builder.getTechRcrdId();
		}
		
		@Override
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techRcrdId")
		public String getTechRcrdId() {
			return techRcrdId;
		}
		
		@Override
		public TechnicalAttributes6__1 build() {
			return this;
		}
		
		@Override
		public TechnicalAttributes6__1.TechnicalAttributes6__1Builder toBuilder() {
			TechnicalAttributes6__1.TechnicalAttributes6__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TechnicalAttributes6__1.TechnicalAttributes6__1Builder builder) {
			ofNullable(getTechRcrdId()).ifPresent(builder::setTechRcrdId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalAttributes6__1 _that = getType().cast(o);
		
			if (!Objects.equals(techRcrdId, _that.getTechRcrdId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (techRcrdId != null ? techRcrdId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TechnicalAttributes6__1 {" +
				"techRcrdId=" + this.techRcrdId +
			'}';
		}
	}

	/*********************** Builder Implementation of TechnicalAttributes6__1  ***********************/
	class TechnicalAttributes6__1BuilderImpl implements TechnicalAttributes6__1.TechnicalAttributes6__1Builder {
	
		protected String techRcrdId;
		
		@Override
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techRcrdId")
		public String getTechRcrdId() {
			return techRcrdId;
		}
		
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("techRcrdId")
		@Override
		public TechnicalAttributes6__1.TechnicalAttributes6__1Builder setTechRcrdId(String _techRcrdId) {
			this.techRcrdId = _techRcrdId == null ? null : _techRcrdId;
			return this;
		}
		
		@Override
		public TechnicalAttributes6__1 build() {
			return new TechnicalAttributes6__1.TechnicalAttributes6__1Impl(this);
		}
		
		@Override
		public TechnicalAttributes6__1.TechnicalAttributes6__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TechnicalAttributes6__1.TechnicalAttributes6__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTechRcrdId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TechnicalAttributes6__1.TechnicalAttributes6__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TechnicalAttributes6__1.TechnicalAttributes6__1Builder o = (TechnicalAttributes6__1.TechnicalAttributes6__1Builder) other;
			
			
			merger.mergeBasic(getTechRcrdId(), o.getTechRcrdId(), this::setTechRcrdId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalAttributes6__1 _that = getType().cast(o);
		
			if (!Objects.equals(techRcrdId, _that.getTechRcrdId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (techRcrdId != null ? techRcrdId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TechnicalAttributes6__1Builder {" +
				"techRcrdId=" + this.techRcrdId +
			'}';
		}
	}
}
