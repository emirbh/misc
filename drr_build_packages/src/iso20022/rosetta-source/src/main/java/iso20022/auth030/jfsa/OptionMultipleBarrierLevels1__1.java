package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.OptionMultipleBarrierLevels1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionMultipleBarrierLevels1__1", builder=OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OptionMultipleBarrierLevels1__1", model="iso20022", builder=OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1BuilderImpl.class, version="${project.version}")
public interface OptionMultipleBarrierLevels1__1 extends RosettaModelObject {

	OptionMultipleBarrierLevels1__1Meta metaData = new OptionMultipleBarrierLevels1__1Meta();

	/*********************** Getter Methods  ***********************/
	SecuritiesTransactionPrice23Choice__1 getLwrLvl();
	SecuritiesTransactionPrice23Choice__1 getUpperLvl();

	/*********************** Build Methods  ***********************/
	OptionMultipleBarrierLevels1__1 build();
	
	OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder toBuilder();
	
	static OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder builder() {
		return new OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionMultipleBarrierLevels1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionMultipleBarrierLevels1__1> getType() {
		return OptionMultipleBarrierLevels1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lwrLvl"), processor, SecuritiesTransactionPrice23Choice__1.class, getLwrLvl());
		processRosetta(path.newSubPath("upperLvl"), processor, SecuritiesTransactionPrice23Choice__1.class, getUpperLvl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionMultipleBarrierLevels1__1Builder extends OptionMultipleBarrierLevels1__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getOrCreateLwrLvl();
		@Override
		SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getLwrLvl();
		SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getOrCreateUpperLvl();
		@Override
		SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getUpperLvl();
		OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder setLwrLvl(SecuritiesTransactionPrice23Choice__1 lwrLvl);
		OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder setUpperLvl(SecuritiesTransactionPrice23Choice__1 upperLvl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lwrLvl"), processor, SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder.class, getLwrLvl());
			processRosetta(path.newSubPath("upperLvl"), processor, SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder.class, getUpperLvl());
		}
		

		OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder prune();
	}

	/*********************** Immutable Implementation of OptionMultipleBarrierLevels1__1  ***********************/
	class OptionMultipleBarrierLevels1__1Impl implements OptionMultipleBarrierLevels1__1 {
		private final SecuritiesTransactionPrice23Choice__1 lwrLvl;
		private final SecuritiesTransactionPrice23Choice__1 upperLvl;
		
		protected OptionMultipleBarrierLevels1__1Impl(OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder builder) {
			this.lwrLvl = ofNullable(builder.getLwrLvl()).map(f->f.build()).orElse(null);
			this.upperLvl = ofNullable(builder.getUpperLvl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lwrLvl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lwrLvl")
		public SecuritiesTransactionPrice23Choice__1 getLwrLvl() {
			return lwrLvl;
		}
		
		@Override
		@RosettaAttribute("upperLvl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("upperLvl")
		public SecuritiesTransactionPrice23Choice__1 getUpperLvl() {
			return upperLvl;
		}
		
		@Override
		public OptionMultipleBarrierLevels1__1 build() {
			return this;
		}
		
		@Override
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder toBuilder() {
			OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder builder) {
			ofNullable(getLwrLvl()).ifPresent(builder::setLwrLvl);
			ofNullable(getUpperLvl()).ifPresent(builder::setUpperLvl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionMultipleBarrierLevels1__1 _that = getType().cast(o);
		
			if (!Objects.equals(lwrLvl, _that.getLwrLvl())) return false;
			if (!Objects.equals(upperLvl, _that.getUpperLvl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lwrLvl != null ? lwrLvl.hashCode() : 0);
			_result = 31 * _result + (upperLvl != null ? upperLvl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionMultipleBarrierLevels1__1 {" +
				"lwrLvl=" + this.lwrLvl + ", " +
				"upperLvl=" + this.upperLvl +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionMultipleBarrierLevels1__1  ***********************/
	class OptionMultipleBarrierLevels1__1BuilderImpl implements OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder {
	
		protected SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder lwrLvl;
		protected SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder upperLvl;
		
		@Override
		@RosettaAttribute("lwrLvl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lwrLvl")
		public SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getLwrLvl() {
			return lwrLvl;
		}
		
		@Override
		public SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getOrCreateLwrLvl() {
			SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder result;
			if (lwrLvl!=null) {
				result = lwrLvl;
			}
			else {
				result = lwrLvl = SecuritiesTransactionPrice23Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperLvl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("upperLvl")
		public SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getUpperLvl() {
			return upperLvl;
		}
		
		@Override
		public SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getOrCreateUpperLvl() {
			SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder result;
			if (upperLvl!=null) {
				result = upperLvl;
			}
			else {
				result = upperLvl = SecuritiesTransactionPrice23Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("lwrLvl")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lwrLvl")
		@Override
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder setLwrLvl(SecuritiesTransactionPrice23Choice__1 _lwrLvl) {
			this.lwrLvl = _lwrLvl == null ? null : _lwrLvl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("upperLvl")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("upperLvl")
		@Override
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder setUpperLvl(SecuritiesTransactionPrice23Choice__1 _upperLvl) {
			this.upperLvl = _upperLvl == null ? null : _upperLvl.toBuilder();
			return this;
		}
		
		@Override
		public OptionMultipleBarrierLevels1__1 build() {
			return new OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Impl(this);
		}
		
		@Override
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder prune() {
			if (lwrLvl!=null && !lwrLvl.prune().hasData()) lwrLvl = null;
			if (upperLvl!=null && !upperLvl.prune().hasData()) upperLvl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLwrLvl()!=null && getLwrLvl().hasData()) return true;
			if (getUpperLvl()!=null && getUpperLvl().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder o = (OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder) other;
			
			merger.mergeRosetta(getLwrLvl(), o.getLwrLvl(), this::setLwrLvl);
			merger.mergeRosetta(getUpperLvl(), o.getUpperLvl(), this::setUpperLvl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionMultipleBarrierLevels1__1 _that = getType().cast(o);
		
			if (!Objects.equals(lwrLvl, _that.getLwrLvl())) return false;
			if (!Objects.equals(upperLvl, _that.getUpperLvl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lwrLvl != null ? lwrLvl.hashCode() : 0);
			_result = 31 * _result + (upperLvl != null ? upperLvl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionMultipleBarrierLevels1__1Builder {" +
				"lwrLvl=" + this.lwrLvl + ", " +
				"upperLvl=" + this.upperLvl +
			'}';
		}
	}
}
