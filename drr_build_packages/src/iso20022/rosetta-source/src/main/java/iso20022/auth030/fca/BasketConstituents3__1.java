package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.BasketConstituents3__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between ISIN and an alternative format for the identification of a financial instrument. ISIN is the preferred format.
 * @version ${project.version}
 */
@RosettaDataType(value="BasketConstituents3__1", builder=BasketConstituents3__1.BasketConstituents3__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="BasketConstituents3__1", model="iso20022", builder=BasketConstituents3__1.BasketConstituents3__1BuilderImpl.class, version="${project.version}")
public interface BasketConstituents3__1 extends RosettaModelObject {

	BasketConstituents3__1Meta metaData = new BasketConstituents3__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Proprietary identification of a security assigned by an institution or organisation.
	 */
	InstrumentIdentification6Choice__1 getInstrmId();

	/*********************** Build Methods  ***********************/
	BasketConstituents3__1 build();
	
	BasketConstituents3__1.BasketConstituents3__1Builder toBuilder();
	
	static BasketConstituents3__1.BasketConstituents3__1Builder builder() {
		return new BasketConstituents3__1.BasketConstituents3__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketConstituents3__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketConstituents3__1> getType() {
		return BasketConstituents3__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instrmId"), processor, InstrumentIdentification6Choice__1.class, getInstrmId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketConstituents3__1Builder extends BasketConstituents3__1, RosettaModelObjectBuilder {
		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getOrCreateInstrmId();
		@Override
		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getInstrmId();
		BasketConstituents3__1.BasketConstituents3__1Builder setInstrmId(InstrumentIdentification6Choice__1 instrmId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instrmId"), processor, InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder.class, getInstrmId());
		}
		

		BasketConstituents3__1.BasketConstituents3__1Builder prune();
	}

	/*********************** Immutable Implementation of BasketConstituents3__1  ***********************/
	class BasketConstituents3__1Impl implements BasketConstituents3__1 {
		private final InstrumentIdentification6Choice__1 instrmId;
		
		protected BasketConstituents3__1Impl(BasketConstituents3__1.BasketConstituents3__1Builder builder) {
			this.instrmId = ofNullable(builder.getInstrmId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("instrmId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("instrmId")
		public InstrumentIdentification6Choice__1 getInstrmId() {
			return instrmId;
		}
		
		@Override
		public BasketConstituents3__1 build() {
			return this;
		}
		
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder toBuilder() {
			BasketConstituents3__1.BasketConstituents3__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketConstituents3__1.BasketConstituents3__1Builder builder) {
			ofNullable(getInstrmId()).ifPresent(builder::setInstrmId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituents3__1 _that = getType().cast(o);
		
			if (!Objects.equals(instrmId, _that.getInstrmId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrmId != null ? instrmId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituents3__1 {" +
				"instrmId=" + this.instrmId +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketConstituents3__1  ***********************/
	class BasketConstituents3__1BuilderImpl implements BasketConstituents3__1.BasketConstituents3__1Builder {
	
		protected InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder instrmId;
		
		@Override
		@RosettaAttribute("instrmId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("instrmId")
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getInstrmId() {
			return instrmId;
		}
		
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getOrCreateInstrmId() {
			InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder result;
			if (instrmId!=null) {
				result = instrmId;
			}
			else {
				result = instrmId = InstrumentIdentification6Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("instrmId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("instrmId")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder setInstrmId(InstrumentIdentification6Choice__1 _instrmId) {
			this.instrmId = _instrmId == null ? null : _instrmId.toBuilder();
			return this;
		}
		
		@Override
		public BasketConstituents3__1 build() {
			return new BasketConstituents3__1.BasketConstituents3__1Impl(this);
		}
		
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder prune() {
			if (instrmId!=null && !instrmId.prune().hasData()) instrmId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInstrmId()!=null && getInstrmId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketConstituents3__1.BasketConstituents3__1Builder o = (BasketConstituents3__1.BasketConstituents3__1Builder) other;
			
			merger.mergeRosetta(getInstrmId(), o.getInstrmId(), this::setInstrmId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituents3__1 _that = getType().cast(o);
		
			if (!Objects.equals(instrmId, _that.getInstrmId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrmId != null ? instrmId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituents3__1Builder {" +
				"instrmId=" + this.instrmId +
			'}';
		}
	}
}
