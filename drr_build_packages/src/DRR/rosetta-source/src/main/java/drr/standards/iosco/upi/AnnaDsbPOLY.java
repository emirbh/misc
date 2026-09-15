package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbPOLYMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbPOLY", builder=AnnaDsbPOLY.AnnaDsbPOLYBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbPOLY", model="drr", builder=AnnaDsbPOLY.AnnaDsbPOLYBuilderImpl.class, version="7.7.0")
public interface AnnaDsbPOLY extends RosettaModelObject {

	AnnaDsbPOLYMeta metaData = new AnnaDsbPOLYMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getPLST();

	/*********************** Build Methods  ***********************/
	AnnaDsbPOLY build();
	
	AnnaDsbPOLY.AnnaDsbPOLYBuilder toBuilder();
	
	static AnnaDsbPOLY.AnnaDsbPOLYBuilder builder() {
		return new AnnaDsbPOLY.AnnaDsbPOLYBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbPOLY> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbPOLY> getType() {
		return AnnaDsbPOLY.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("PLST"), processor, AnnaDsbEmpty.class, getPLST());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbPOLYBuilder extends AnnaDsbPOLY, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePLST();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getPLST();
		AnnaDsbPOLY.AnnaDsbPOLYBuilder setPLST(AnnaDsbEmpty PLST);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("PLST"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getPLST());
		}
		

		AnnaDsbPOLY.AnnaDsbPOLYBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbPOLY  ***********************/
	class AnnaDsbPOLYImpl implements AnnaDsbPOLY {
		private final AnnaDsbEmpty pLST;
		
		protected AnnaDsbPOLYImpl(AnnaDsbPOLY.AnnaDsbPOLYBuilder builder) {
			this.pLST = ofNullable(builder.getPLST()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("PLST")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("PLST")
		public AnnaDsbEmpty getPLST() {
			return pLST;
		}
		
		@Override
		public AnnaDsbPOLY build() {
			return this;
		}
		
		@Override
		public AnnaDsbPOLY.AnnaDsbPOLYBuilder toBuilder() {
			AnnaDsbPOLY.AnnaDsbPOLYBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbPOLY.AnnaDsbPOLYBuilder builder) {
			ofNullable(getPLST()).ifPresent(builder::setPLST);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbPOLY _that = getType().cast(o);
		
			if (!Objects.equals(pLST, _that.getPLST())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pLST != null ? pLST.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbPOLY {" +
				"PLST=" + this.pLST +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbPOLY  ***********************/
	class AnnaDsbPOLYBuilderImpl implements AnnaDsbPOLY.AnnaDsbPOLYBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder pLST;
		
		@Override
		@RosettaAttribute("PLST")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("PLST")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getPLST() {
			return pLST;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePLST() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (pLST!=null) {
				result = pLST;
			}
			else {
				result = pLST = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("PLST")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("PLST")
		@Override
		public AnnaDsbPOLY.AnnaDsbPOLYBuilder setPLST(AnnaDsbEmpty _pLST) {
			this.pLST = _pLST == null ? null : _pLST.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbPOLY build() {
			return new AnnaDsbPOLY.AnnaDsbPOLYImpl(this);
		}
		
		@Override
		public AnnaDsbPOLY.AnnaDsbPOLYBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbPOLY.AnnaDsbPOLYBuilder prune() {
			if (pLST!=null && !pLST.prune().hasData()) pLST = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPLST()!=null && getPLST().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbPOLY.AnnaDsbPOLYBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbPOLY.AnnaDsbPOLYBuilder o = (AnnaDsbPOLY.AnnaDsbPOLYBuilder) other;
			
			merger.mergeRosetta(getPLST(), o.getPLST(), this::setPLST);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbPOLY _that = getType().cast(o);
		
			if (!Objects.equals(pLST, _that.getPLST())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pLST != null ? pLST.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbPOLYBuilder {" +
				"PLST=" + this.pLST +
			'}';
		}
	}
}
